package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PrizeTest {
    @Test
    void 결과_값이_비어있으면_오류가_발생한다() {
        assertThatThrownBy(() -> new Prize(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void 결과_값이_공백이면_오류가_발생한다() {
        assertThatThrownBy(() -> new Prize(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_결과_값을_그대로_가진다() {
        Prize prize = new Prize("꽝");

        assertThat(prize.getPrize()).isEqualTo("꽝");
    }
}
