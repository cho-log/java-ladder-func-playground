package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("5글자 이하면 생성된다.")
    void 다섯_글자_이하면_생성된다() {
        assertThat(new Name("tommy").value()).isEqualTo("tommy");
    }

    @Test
    @DisplayName("5글자를 넘으면 예외가 발생한다.")
    void 다섯_글자를_넘으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("sixsix"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
