package controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

public class LadderControllerTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("잘못된 이름을 입력하면 안내 후 다시 입력받아 진행한다.")
    void 잘못된_이름을_입력하면_다시_입력받는다() {
        run("neo\nneo,brown\n꽝,5000\n1\nall\n");

        assertThat(result()).contains("[ERROR]", "사다리 결과");
    }

    @Test
    @DisplayName("잘못된 높이를 입력하면 안내 후 다시 입력받아 진행한다.")
    void 잘못된_높이를_입력하면_다시_입력받는다() {
        run("neo,brown\n꽝,5000\nabc\n1\nall\n");

        assertThat(result()).contains("[ERROR]", "사다리 결과");
    }

    @Test
    @DisplayName("없는 이름을 조회하면 안내 후 다시 입력받아 진행한다.")
    void 없는_이름을_조회하면_다시_입력받는다() {
        run("neo,brown\n꽝,5000\n1\nnone\nneo\nall\n");

        assertThat(result()).contains("[ERROR]", "neo : ");
    }

    private void run(String input) {
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
        new LadderController(new InputView(), new OutputView()).run();
    }

    private String result() {
        return output.toString();
    }

}
