package domain.outcome;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OutcomeTest {
    @Test
    void 정상적인_결과를_입력하면_outcome을_생성한다() {
        // given
        String input = "꽝";

        // when
        Outcome outcome = new Outcome(input);

        // then
        assertEquals("꽝", outcome.getOutcome());
    }

    @Test
    void 결과가_빈_문자열이면_예외가_발생한다() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Outcome(input));
    }

    @Test
    void 결과가_공백이면_예외가_발생한다() {
        // given
        String input = "   ";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Outcome(input));
    }

    @Test
    void 결과의_앞뒤_공백이_제거되어서_저장된다() {
        // given
        String input = "   꽝   ";

        // when
        Outcome outcome = new Outcome(input);

        // then
        assertEquals("꽝", outcome.getOutcome());
    }
}
