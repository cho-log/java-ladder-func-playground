package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "neo", "tommy"})
    @DisplayName("1자 이상 5자 이하의 이름은 생성된다")
    void createName(String input) {
        Name name = new Name(input);

        assertThat(name.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("이름이 5자를 넘으면 예외가 발생한다")
    void nameTooLong() {
        assertThatThrownBy(() -> new Name("brownie"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("이름이 null이거나 비어 있으면 예외가 발생한다")
    void nameBlank(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 비어 있을 수 없습니다.");
    }
}
