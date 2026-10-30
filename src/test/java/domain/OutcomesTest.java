package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OutcomesTest {
    @Test
    void 저장된_결과수를_반환한다() {
        // given & when
        Outcomes outcomes = createOutcomes();

        // then
        assertEquals(4, outcomes.getSize());
    }

    @Test
    void 첫번째_위치의_결과를_반환한다() {
        // given
        Outcomes outcomes = createOutcomes();
        Position position = new Position(0);

        // when
        Outcome outcome = outcomes.getOutcomeByPosition(position);

        // then
        assertEquals("꽝", outcome.getOutcome());
    }

    @Test
    void 마지막_위치의_결과를_반환한다() {
        // given
        Outcomes outcomes = createOutcomes();
        Position position = new Position(3);

        // when
        Outcome outcome = outcomes.getOutcomeByPosition(position);

        // then
        assertEquals("3000", outcome.getOutcome());
    }

    @Test
    void 존재하지_않는_위치의_결과를_조회하면_예외가_발생한다() {
        // given
        Outcomes outcomes = createOutcomes();
        Position position = new Position(4);

        // when & then
        assertThrows(IndexOutOfBoundsException.class, () -> outcomes.getOutcomeByPosition(position));
    }

    private Outcomes createOutcomes() {
        return new Outcomes(List.of(
                new Outcome("꽝"),
                new Outcome("5000"),
                new Outcome("꽝"),
                new Outcome("3000")
        ));
    }
}
