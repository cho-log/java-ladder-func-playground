package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultsTest {
    @Test
    void matchesEachParticipantToDestinationOutcome() {
        GameResults results = createGame().getResults();
        assertThat(results.getResult(new ParticipantName("neo")).getValue()).isEqualTo("3000");
        assertThat(results.getResult(new ParticipantName("brown")).getValue()).isEqualTo("꽝");
        assertThat(results.getResult(new ParticipantName("brie")).getValue()).isEqualTo("5000");
    }

    @Test
    void returnsAllResultsInParticipantOrder() {
        assertThat(createGame().getResults().getResults().keySet()).extracting(ParticipantName::getValue)
                .containsExactly("neo", "brown", "brie");
    }

    @Test
    void keepsResultsWhenQueriedSeveralTimes() {
        GameResults results = createGame().getResults();
        assertThat(results.getResult(new ParticipantName("neo")).getValue()).isEqualTo("3000");
        assertThat(results.getResult(new ParticipantName("neo")).getValue()).isEqualTo("3000");
    }

    @Test
    void rejectsUnknownParticipant() {
        assertThatThrownBy(() -> createGame().getResults().getResult(new ParticipantName("tommy")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsOutcomeCountDifferentFromParticipantCount() {
        Participants participants = new Participants(List.of("neo", "brie"));
        assertThatThrownBy(() -> new LadderGame(participants, new Outcomes(List.of("꽝")),
                new LadderHeight(2), () -> Connection.DISCONNECTED))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void allowsDuplicateOutcomes() {
        Participants participants = new Participants(List.of("neo", "brie"));
        LadderGame game = new LadderGame(participants, new Outcomes(List.of("꽝", "꽝")),
                new LadderHeight(1), () -> Connection.CONNECTED);
        assertThat(game.getResults().getResults().values()).extracting(Outcome::getValue)
                .containsExactly("꽝", "꽝");
    }

    @Test
    void preventsChangingPublishedResults() {
        assertThatThrownBy(() -> createGame().getResults().getResults().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    private LadderGame createGame() {
        return new LadderGame(new Participants(List.of("neo", "brown", "brie")),
                new Outcomes(List.of("꽝", "5000", "3000")), new LadderHeight(2),
                new FixedConnectionGenerator(List.of(
                        Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED)));
    }
}
