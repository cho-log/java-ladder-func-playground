package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderResultTest {

    private final Names names = new Names(List.of("neo", "brown", "brie", "tommy"));
    private final Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), 4);

    @ParameterizedTest
    @CsvSource({"neo, 5000", "brown, 꽝", "brie, 3000", "tommy, 꽝"})
    @DisplayName("사다리를 타고 도착한 위치의 결과를 받는다")
    void findResultOf(String name, String expected) {
        Ladder ladder = new Ladder(4, 1, () -> true);
        LadderResult result = new LadderResult(names, prizes, ladder);

        assertThat(result.findResultOf(name)).isEqualTo(new Prize(expected));
    }

    @Test
    @DisplayName("다리가 없으면 바로 아래 결과를 받는다")
    void findResultWithoutPoints() {
        Ladder ladder = new Ladder(4, 3, () -> false);
        LadderResult result = new LadderResult(names, prizes, ladder);

        assertThat(result.findResultOf("neo")).isEqualTo(new Prize("꽝"));
        assertThat(result.findResultOf("brown")).isEqualTo(new Prize("5000"));
    }

    @Test
    @DisplayName("전체 결과는 참가자 입력 순서대로 반환된다")
    void findAllResults() {
        Ladder ladder = new Ladder(4, 1, () -> true);
        LadderResult result = new LadderResult(names, prizes, ladder);

        assertThat(result.findAllResults()).containsExactly(
                entry(new Name("neo"), new Prize("5000")),
                entry(new Name("brown"), new Prize("꽝")),
                entry(new Name("brie"), new Prize("3000")),
                entry(new Name("tommy"), new Prize("꽝"))
        );
    }

    @Test
    @DisplayName("존재하지 않는 참가자를 조회하면 예외가 발생한다")
    void findResultOfUnknownName() {
        Ladder ladder = new Ladder(4, 1, () -> true);
        LadderResult result = new LadderResult(names, prizes, ladder);

        assertThatThrownBy(() -> result.findResultOf("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 참가자입니다.");
    }

}