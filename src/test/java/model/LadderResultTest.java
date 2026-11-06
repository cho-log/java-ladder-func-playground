package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    private LadderResult result;

    @BeforeEach
    void setUp() {
        Map<Name, Prize> results = new LinkedHashMap<>();
        results.put(new Name("neo"), new Prize("5000"));
        results.put(new Name("brown"), new Prize("꽝"));
        result = new LadderResult(results);
    }

    @Test
    @DisplayName("이름으로 결과를 찾는다")
    void findResultOf() {
        // when
        Prize prize = result.findResultOf("neo");

        // then
        assertThat(prize.getPrize()).isEqualTo("5000");
    }

    @Test
    @DisplayName("전체 결과는 넣은 순서대로 반환된다")
    void findAllResults() {
        // when
        Map<Name, Prize> allResults = result.findAllResults();

        // then
        assertThat(allResults.keySet())
                .containsExactly(new Name("neo"), new Name("brown"));
        assertThat(allResults.values())
                .extracting(Prize::getPrize)
                .containsExactly("5000", "꽝");
    }

    @Test
    @DisplayName("존재하지 않는 참가자를 조회하면 예외가 발생한다")
    void findResultOfUnknownName() {
        // when & then
        assertThatThrownBy(() -> result.findResultOf("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 참가자입니다.");
    }

}