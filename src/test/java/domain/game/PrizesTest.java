package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Position;
import domain.Width;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PrizesTest {

    @Test
    void 결과_개수와_넓이가_다르면_예외가_발생한다() {
        assertThatThrownBy(() -> Prizes.createPrizes(List.of("꽝", "5000", "꽝"), new Width(4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 도착_위치의_순서에_있는_결과를_찾는다() {
        Prizes prizes = Prizes.createPrizes(List.of("꽝", "5000", "꽝", "3000"), new Width(4));

        assertThat(prizes.findPrize(new Position(1)).getPrize()).isEqualTo("5000");
    }

    @Test
    void 결과_목록에_빈_이름이_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> Names.createNames(List.of("꽝", "100", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
