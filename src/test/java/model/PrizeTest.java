package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "3000"})
    @DisplayName("비어 있지 않은 실행 결과는 생성된다")
    void createPrize(String input) {
        Prize prize = new Prize(input);

        assertThat(prize.getPrize()).isEqualTo(input);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("실행 결과가 null이거나 비어 있으면 예외가 발생한다")
    void prizeBlank(String input) {
        assertThatThrownBy(() -> new Prize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 비어 있을 수 없습니다.");
    }
}