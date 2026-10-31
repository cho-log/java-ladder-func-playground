package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerPrizesTest {

    private final Names names = Names.from("neo,brown,brie,tommy");
    private final Prizes prizes = Prizes.from("꽝,5000,꽝,3000");
    private final LadderResult result = new LadderResult(List.of(
            new Position(0), new Position(3), new Position(2), new Position(1)));

    @Test
    @DisplayName("도착 위치에 해당하는 결과를 참여자에게 짝지어 준다.")
    void 도착_위치에_해당하는_결과를_짝지어_준다() {
        PlayerPrizes playerPrizes = PlayerPrizes.of(names, prizes, result);

        assertThat(playerPrizes.find("neo").prize().value()).isEqualTo("꽝");
        assertThat(playerPrizes.find("brown").prize().value()).isEqualTo("3000");
        assertThat(playerPrizes.find("brie").prize().value()).isEqualTo("꽝");
        assertThat(playerPrizes.find("tommy").prize().value()).isEqualTo("5000");
    }

    @Test
    @DisplayName("전체 결과는 참여자 수만큼 나온다.")
    void 전체_결과는_참여자_수만큼_나온다() {
        PlayerPrizes playerPrizes = PlayerPrizes.of(names, prizes, result);

        assertThat(playerPrizes.all()).hasSize(4);
    }

    @Test
    @DisplayName("없는 참여자를 찾으면 예외가 발생한다.")
    void 없는_참여자를_찾으면_예외가_발생한다() {
        PlayerPrizes playerPrizes = PlayerPrizes.of(names, prizes, result);

        assertThatThrownBy(() -> playerPrizes.find("none"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
