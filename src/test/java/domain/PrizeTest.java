package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    @DisplayName("5글자를 넘으면 예외가 발생한다.")
    void 다섯_글자를_넘으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Prize("sixsix"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 결과면 예외가 발생한다.")
    void 빈_결과면_예외가_발생한다() {
        assertThatThrownBy(() -> new Prize(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백만 있는 결과면 예외가 발생한다.")
    void 공백만_있는_결과면_예외가_발생한다() {
        assertThatThrownBy(() -> new Prize("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
