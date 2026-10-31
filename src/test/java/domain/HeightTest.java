package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HeightTest {

    @Test
    void 높이가_1_이상이면_생성된다() {
        Height height = new Height(1);

        assertThat(height.getHeight()).isEqualTo(1);
    }

    @Test
    void 높이가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
