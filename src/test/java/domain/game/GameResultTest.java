package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Connection;
import domain.Height;
import domain.Ladder;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameResultTest {
    private final Names names = Names.createNames(List.of("neo", "brown", "brie", "tommy"));
    private final Prizes prizes = Prizes.createPrizes(List.of("꽝", "5000", "꽝", "3000"));
    private final Ladder ladder = Ladder.createLadder(names.toWidth(), new Height(1), () -> Connection.CONNECTED);

    @Test
    void 이름으로_결과를_찾는다() {
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        assertThat(gameResult.findPrize("neo").getPrize()).isEqualTo("5000");
    }

    @Test
    void 없는_이름을_찾으면_오류가_발생한다() {
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        assertThatThrownBy(() -> gameResult.findPrize("jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 목록에 존재하지 않습니다.");
    }

    @Test
    void 다섯_글자가_넘는_이름을_찾아도_없는_이름_오류가_발생한다() {
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        assertThatThrownBy(() -> gameResult.findPrize("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 목록에 존재하지 않습니다.");
    }

    @Test
    void 이름_개수와_결과_개수가_다르면_오류가_발생한다() {
        Prizes threePrizes = Prizes.createPrizes(List.of("꽝", "5000", "꽝"));

        assertThatThrownBy(() -> GameResult.validateSameCount(names, threePrizes))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전체_결과는_이름을_입력한_순서대로_나온다() {
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        List<String> resultNames = gameResult.getResults().keySet().stream()
                .map(Name::getName)
                .toList();
        List<String> resultPrizes = gameResult.getResults().values().stream()
                .map(Prize::getPrize)
                .toList();

        assertThat(resultNames).containsExactly("neo", "brown", "brie", "tommy");
        assertThat(resultPrizes).containsExactly("5000", "꽝", "3000", "꽝");
    }
}
