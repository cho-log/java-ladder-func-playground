package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizesTest {

    @Test
    @DisplayName("입력한 순서대로 실행 결과 목록을 반환한다")
    void getPrizes() {
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), 4);

        assertThat(prizes.getPrizes()).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    @DisplayName("실행 결과 개수와 참가자 수가 다르면 예외가 발생한다")
    void countMismatch(int countOfPerson) {
        List<String> inputs = List.of("꽝", "5000", "꽝", "3000");

        assertThatThrownBy(() -> new Prizes(inputs, countOfPerson))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수는 참가자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("실행 결과 중 하나라도 비어 있으면 예외가 발생한다")
    void containsBlankPrize() {
        assertThatThrownBy(() -> new Prizes(List.of("꽝", " ", "3000"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 비어 있을 수 없습니다.");
    }

}