import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HeightTest {
    @Test
    void 사다리_높이가_1보다_작으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }

    @Test
    void 사다리_높이가_1이면_정상적으로_생성된다() {
        assertDoesNotThrow(() -> new Height(1));
    }

    @Test
    void 사다리_높이가_1보다_크면_정상적으로_생성된다() {
        assertDoesNotThrow(() -> new Height(2));
    }
}
