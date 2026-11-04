package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("오른쪽으로 이동하면 위치가 1 증가한다.")
    void 오른쪽으로_이동하면_위치가_1_증가한다() {
        Position position = new Position(1);

        assertThat(position.moveRight().value()).isEqualTo(2);
    }

    @Test
    @DisplayName("왼쪽으로 이동하면 위치가 1 감소한다.")
    void 왼쪽으로_이동하면_위치가_1_감소한다() {
        Position position = new Position(1);

        assertThat(position.moveLeft().value()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동해도 원래 위치는 바뀌지 않는다.")
    void 이동해도_원래_위치는_바뀌지_않는다() {
        Position position = new Position(1);

        position.moveRight();

        assertThat(position.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치가 0 미만이면 예외가 발생한다.")
    void 위치가_0_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("맨 왼쪽에서 왼쪽으로 이동하면 예외가 발생한다.")
    void 맨_왼쪽에서_왼쪽으로_이동하면_예외가_발생한다() {
        Position position = new Position(0);

        assertThatThrownBy(() -> position.moveLeft())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
