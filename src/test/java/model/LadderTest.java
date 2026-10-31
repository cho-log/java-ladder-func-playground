package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @Test
    @DisplayName("높이만큼 줄이 생성된다")
    void lineCount() {
        Ladder ladder = new Ladder(4, 5, () -> false);

        assertThat(ladder.getLines()).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 3", "3, 2"})
    @DisplayName("높이가 1이면 한 번만 다리를 건넌다")
    void moveOneLine(int start, int expected) {
        Ladder ladder = new Ladder(4, 1, () -> true);

        assertThat(ladder.move(start)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 2", "3, 3"})
    @DisplayName("같은 다리를 두 번 건너면 제자리로 돌아온다")
    void moveTwoLines(int start, int expected) {
        Ladder ladder = new Ladder(4, 2, () -> true);

        assertThat(ladder.move(start)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 2", "3, 3"})
    @DisplayName("다리가 없으면 출발한 위치에 도착한다")
    void moveWithoutPoints(int start, int expected) {
        Ladder ladder = new Ladder(4, 5, () -> false);

        assertThat(ladder.move(start)).isEqualTo(expected);
    }

}