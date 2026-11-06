package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointsTest {

    @Test
    @DisplayName("다리가 연속되면 예외가 발생한다")
    void continuousPoints() {
        assertThatThrownBy(() -> new Points(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리는 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("다리가 연속되지 않으면 생성된다")
    void notContinuousPoints() {
        assertThatCode(() -> new Points(List.of(true, false, true)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("해당 위치에 다리가 있는지 확인한다")
    void hasPointAt() {
        Points points = new Points(List.of(true, false, true));

        assertThat(points.hasPointAt(0)).isTrue();
        assertThat(points.hasPointAt(1)).isFalse();
    }

    @Test
    @DisplayName("범위를 벗어난 위치에는 다리가 없다")
    void hasPointAtOutOfRange() {
        Points points = new Points(List.of(true, false, true));

        assertThat(points.hasPointAt(-1)).isFalse();
        assertThat(points.hasPointAt(3)).isFalse();
    }
}