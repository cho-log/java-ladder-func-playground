package domain.game;

import domain.ladder.Connection;
import domain.ladder.Ladder;
import domain.ladder.LadderResults;
import domain.ladder.Line;
import domain.ladder.Width;
import domain.outcome.Outcome;
import domain.outcome.Outcomes;
import domain.participant.Participant;
import domain.participant.Participants;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameResultsTest {
    @Test
    void 참여자수와_결과수가_다르면_예외가_발생한다() {
        // given
        Participants participants = createParticipants();
        Outcomes outcomes = new Outcomes(List.of(
                new Outcome("1"),
                new Outcome("2")
        ));
        LadderResults ladderResults = createLadderResults();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new GameResults(participants, outcomes, ladderResults));
    }

    @Test
    void 참여자수와_사다리_결과수가_다르면_예외가_발생한다() {
        // given
        Participants participants = createParticipants();
        Outcomes outcomes = createOutcomes();
        LadderResults ladderResults = new LadderResults(new Width(4), new Ladder(List.of(
                new Line(List.of(
                        Connection.CONNECTED,
                        Connection.DISCONNECTED,
                        Connection.CONNECTED
                )),
                new Line(List.of(
                        Connection.DISCONNECTED,
                        Connection.CONNECTED,
                        Connection.DISCONNECTED
                ))
        )));

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new GameResults(participants, outcomes, ladderResults));
    }

    @Test
    void 사다리결과에_참여자와_당첨결과를_연결한다() {
        // given & when
        GameResults gameResults = createGameResults();

        // then
        assertEquals("3000", getOutcome(gameResults, "a"));
        assertEquals("2000", getOutcome(gameResults, "b"));
        assertEquals("1000", getOutcome(gameResults, "c"));
    }

    @Test
    void 특정_참여자의_결과를_조회한다() {
        // given
        Participants participants = createParticipants();
        Outcomes outcomes = createOutcomes();
        LadderResults ladderResults = createLadderResults();
        GameResults gameResults = new GameResults(participants, outcomes, ladderResults);

        // when
        GameResult gameResult = gameResults.getGameResult(new Participant("a"));

        // then
        assertEquals("a", gameResult.getParticipant().getName());
        assertEquals("3000", gameResult.getOutcome().getOutcome());
    }

    @Test
    void 존재하지_않는_참여자를_조회하면_예외가_발생한다() {
        // given
        Participants participants = createParticipants();
        Outcomes outcomes = createOutcomes();
        LadderResults ladderResults = createLadderResults();
        GameResults gameResults = new GameResults(participants, outcomes, ladderResults);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> gameResults.getGameResult(new Participant("unknown")));
    }

    private Participants createParticipants() {
        return new Participants(List.of(
                new Participant("a"),
                new Participant("b"),
                new Participant("c")
        ));
    }

    private Outcomes createOutcomes() {
        return new Outcomes(List.of(
                new Outcome("1000"),
                new Outcome("2000"),
                new Outcome("3000")
        ));
    }

    private LadderResults createLadderResults() {
        return new LadderResults(
                new Width(3),
                new Ladder(List.of(
                        new Line(List.of(Connection.CONNECTED, Connection.DISCONNECTED)),
                        new Line(List.of(Connection.DISCONNECTED, Connection.CONNECTED)),
                        new Line(List.of(Connection.CONNECTED, Connection.DISCONNECTED))
                ))
        );
    }

    private GameResults createGameResults() {
        Participants participants = createParticipants();
        Outcomes outcomes = createOutcomes();
        LadderResults ladderResults = createLadderResults();

        return new GameResults(participants, outcomes, ladderResults);
    }

    private String getOutcome(GameResults gameResults, String name) {
        Participant participant = new Participant(name);
        return gameResults.getGameResult(participant).getOutcome().getOutcome();
    }
}
