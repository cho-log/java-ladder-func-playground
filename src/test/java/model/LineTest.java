package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @Test
    @DisplayName("참가자 수보다 하나 적은 개수의 다리 자리가 생긴다")
    void pointSize() {
        Line line = new Line(4, () -> false);

        assertThat(line.getLine()).hasSize(3);
    }

    @Test
    @DisplayName("앞에 다리가 있으면 다음 자리는 건너뛰고 생성한다")
    void noConsecutivePoints() {
        Line line = new Line(5, () -> true);

        assertThat(line.getLine()).containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("다리를 놓지 않으면 모든 자리가 비어 있다")
    void noPoints() {
        Line line = new Line(4, () -> false);

        assertThat(line.getLine()).containsExactly(false, false, false);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 3", "3, 2"})
    @DisplayName("다리가 있으면 그 방향으로 이동한다")
    void moveAlongPoint(int start, int expected) {
        Line line = new Line(4, () -> true);

        assertThat(line.moveLine(start)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 2", "3, 3"})
    @DisplayName("다리가 없으면 제자리에 있다")
    void stayWithoutPoint(int start, int expected) {
        Line line = new Line(4, () -> false);

        assertThat(line.moveLine(start)).isEqualTo(expected);
    }
}