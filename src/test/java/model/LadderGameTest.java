package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {
    private final Names names = new Names(List.of("neo", "brown", "brie", "tommy"));
    private final Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), 4);

    @ParameterizedTest
    @CsvSource({"neo, 5000", "brown, 꽝", "brie, 3000", "tommy, 꽝"})
    @DisplayName("사다리를 타고 도착한 위치의 결과를 받는다")
    void playWithPoints(String name, String expected) {
        // given
        Ladder ladder = new Ladder(4, new Height(1), () -> true);

        // when
        LadderResult result = new LadderGame(names, prizes, ladder).getLadderResult();

        // then
        assertThat(result.findResultOf(name).getPrize()).isEqualTo(expected);
    }

    @Test
    @DisplayName("다리가 없으면 바로 아래 결과를 받는다")
    void playWithoutPoints() {
        // given
        Ladder ladder = new Ladder(4, new Height(3), () -> false);

        // when
        LadderResult result = new LadderGame(names, prizes, ladder).getLadderResult();

        // then
        assertThat(result.findResultOf("neo").getPrize()).isEqualTo("꽝");
        assertThat(result.findResultOf("brown").getPrize()).isEqualTo("5000");
    }

    @Test
    @DisplayName("실행 결과 개수가 참가자 수와 다르면 예외가 발생한다")
    void prizeCountMismatch() {
        // given
        Prizes threePrizes = new Prizes(List.of("꽝", "5000", "꽝"), 4);
        Ladder ladder = new Ladder(4, new Height(1), () -> true);

        // when & then
        assertThatThrownBy(() -> new LadderGame(names, threePrizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수는 참가자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("사다리 너비가 참가자 수와 다르면 예외가 발생한다")
    void ladderWidthMismatch() {
        // given
        Ladder ladder = new Ladder(5, new Height(1), () -> true);

        // when & then
        assertThatThrownBy(() -> new LadderGame(names, prizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 너비는 참가자 수와 같아야 합니다.");
    }
}