import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WidthTest {
    @Test
    void 사다리_넓이가_2보다_작으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Width(1));
    }

    @Test
    void 사다리_넓이가_2이면_정상적으로_생성된다() {
        assertDoesNotThrow(() -> new Width(2));
    }

    @Test
    void 사다리_넓이가_2보다_크면_정상적으로_생성된다() {
        assertDoesNotThrow(() -> new Width(3));
    }
}
