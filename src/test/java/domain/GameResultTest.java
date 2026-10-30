package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameResultTest {
    @Test
    void 참여자와_당첨결과를_저장한다() {
        // given
        Participant participant = new Participant("abc");
        Outcome outcome = new Outcome("3000");

        // when
        GameResult gameResult = new GameResult(participant, outcome);

        // then
        assertSame(participant, gameResult.getParticipant());
        assertSame(outcome, gameResult.getOutcome());
    }
}
