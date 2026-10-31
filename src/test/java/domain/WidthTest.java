package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WidthTest {

    @Test
    void 넓이가_2_이상이면_생성된다() {
        Width width = new Width(2);

        assertThat(width.getWidth()).isEqualTo(2);
    }

    @Test
    void 넓이가_2_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Width(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 칸_개수는_넓이보다_1_작다() {
        Width width = new Width(4);

        assertThat(width.connectionCount()).isEqualTo(3);
    }
}
