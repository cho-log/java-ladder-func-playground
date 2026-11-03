import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.GameResult;
import domain.Name;
import domain.NameResultPairs;
import domain.Names;
import domain.Result;
import domain.Results;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    void 사다리_도착_위치에_따라_결과가_매핑된다() {
        Names names = new Names(List.of(
                new Name("neo"),
                new Name("brown"),
                new Name("brie")
        ));
        Results results = new Results(List.of(
                new Result("꽝"),
                new Result("5000"),
                new Result("10000")
        ));

        GameResult gameResult = new GameResult(new NameResultPairs(names, results), List.of(2, 0, 1));

        assertEquals("10000", gameResult.findResult(new Name("neo")).getValue());
        assertEquals("꽝", gameResult.findResult(new Name("brown")).getValue());
        assertEquals("5000", gameResult.findResult(new Name("brie")).getValue());
    }

    @Test
    void 전체_결과는_참여자_입력_순서를_유지한다() {
        Names names = new Names(List.of(new Name("neo"),
                new Name("brown"),new Name("brie")));
        Results results = new Results(List.of(new Result("꽝"),
                new Result("5000"),new Result("10000")));
        GameResult gameResult = new GameResult(new NameResultPairs(names, results), List.of(0, 1, 2));
        List<Name> actualNames = new ArrayList<>();
        for (Map.Entry<Name, Result> entry : gameResult.getResultEntries()) {
            actualNames.add(entry.getKey());
        }
        assertEquals(names.getNames(), actualNames);
    }

    @Test
    void 참여자와_도착_위치_개수가_다르면_예외가_발생한다() {
        Names names = new Names(List.of(
                new Name("neo"),
                new Name("brown")
        ));
        Results results = new Results(List.of(new Result("꽝"), new Result("5000")));
        NameResultPairs nameResultPairs = new NameResultPairs(names, results);

        assertThrows(IllegalArgumentException.class,
                () -> new GameResult(nameResultPairs, List.of(0)));
    }

    @Test
    void 존재하지_않는_참여자를_조회하면_예외가_발생한다() {
        Names names = new Names(List.of(new Name("neo")));
        Results results = new Results(List.of(new Result("꽝")));
        GameResult gameResult = new GameResult(new NameResultPairs(names, results), List.of(0));

        assertThrows(IllegalArgumentException.class,
                () -> gameResult.findResult(new Name("brown")));
    }
}
