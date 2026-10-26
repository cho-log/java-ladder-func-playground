import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputViewTest {
    @Test
    void 넓이에_정수가_아닌_값을_입력하면_예외가_발생한다() {
        InputView inputView = new InputView(new Scanner("abc"));

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                inputView::readWidth
        );

        assertEquals(
                "사다리의 넓이는 정수로 입력해야 합니다.",
                exception.getMessage()
        );
    }

    @Test
    void 높이에_정수가_아닌_값을_입력하면_예외가_발생한다() {
        InputView inputView = new InputView(new Scanner("abc"));

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                inputView::readHeight
        );

        assertEquals(
                "사다리의 높이는 정수로 입력해야 합니다.",
                exception.getMessage()
        );
    }

    @Test
    void 넓이에_정수를_입력하면_정상적으로_변환된다() {
        InputView inputView = new InputView(new Scanner("4"));

        int width = inputView.readWidth();

        assertEquals(4, width);
    }

    @Test
    void 높이에_정수를_입력하면_정상적으로_변환된다() {
        InputView inputView = new InputView(new Scanner("4"));

        int height = inputView.readHeight();

        assertEquals(4, height);
    }

    @Test
    void 입력값_앞뒤에_공백이_있어도_정상적으로_변환된다() {
        InputView inputView = new InputView(new Scanner("    4    "));

        int width = inputView.readWidth();

        assertEquals(4, width);
    }
}
