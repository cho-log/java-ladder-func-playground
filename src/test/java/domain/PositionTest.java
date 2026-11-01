package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionTest {

    @Test
    void 위치가_0_이상이면_생성된다() {
        Position position = new Position(0);

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 위치가_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오른쪽으로_이동하면_1_커진다() {
        Position position = new Position(1);

        assertThat(position.moveToRight().getPosition()).isEqualTo(2);
    }

    @Test
    void 왼쪽으로_이동하면_1_작아진다() {
        Position position = new Position(1);

        assertThat(position.moveToLeft().getPosition()).isEqualTo(0);
    }

    @Test
    void 위치_0에서_왼쪽으로_이동하면_예외가_발생한다() {
        Position position = new Position(0);

        assertThatThrownBy(position::moveToLeft)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
