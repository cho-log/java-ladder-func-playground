package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderSizeTest {

    @Test
    @DisplayName("크기가 1 이상이면 생성된다.")
    void 크기가_1_이상이면_생성된다() {
        LadderSize size = new LadderSize(1);

        assertThat(size.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("크기가 1 미만이면 예외가 발생한다.")
    void 크기가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LadderSize(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
