package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NamesTest {
    private final Names names = Names.createNames(List.of("neo", "brown", "brie", "tommy"));

    @Test
    void 이름의_순서가_시작_위치가_된다() {
        assertThat(names.findPosition(new Name("brown")).getPosition()).isEqualTo(1);
    }

    @Test
    void 없는_이름을_찾으면_예외가_발생한다() {
        assertThatThrownBy(() -> names.findPosition(new Name("jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_개수가_넓이가_된다() {
        assertThat(names.toWidth().getWidth()).isEqualTo(4);
    }

    @Test
    void 이름이_1개면_넓이를_만들_수_없다() {
        Names oneName = Names.createNames(List.of("neo"));

        assertThatThrownBy(oneName::toWidth)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
