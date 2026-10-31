package domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PrizeTest {

    @Test
    void 입력한_결과_값을_그대로_가진다() {
        Prize prize = new Prize("꽝");

        assertThat(prize.getPrize()).isEqualTo("꽝");
    }
}
