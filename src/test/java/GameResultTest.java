import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.GameResult;
import domain.Name;
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
        ), names.size());

        GameResult gameResult = new GameResult(names, List.of(2, 0, 1), results);

        assertEquals("10000", gameResult.findResult(new Name("neo")).getValue());
        assertEquals("꽝", gameResult.findResult(new Name("brown")).getValue());
        assertEquals("5000", gameResult.findResult(new Name("brie")).getValue());
    }

    @Test
    void 전체_결과는_참여자_입력_순서를_유지한다() {
        Names names = new Names(List.of(new Name("neo"),
                new Name("brown"),new Name("brie")));
        Results results = new Results(List.of(new Result("꽝"),
                new Result("5000"),new Result("10000")), names.size());
        GameResult gameResult = new GameResult(names, List.of(0, 1, 2), results);
        List<Name> actualNames = new ArrayList<>();
        for (Map.Entry<Name, Result> entry : gameResult.getResultEntries()) {
            actualNames.add(entry.getKey());
        }
        assertEquals(names.getNames(), actualNames);
    }

    @Test
    void 이름과_실행_결과_개수가_다르면_예외가_발생한다() {
        Names names = new Names(List.of(
                new Name("neo"),
                new Name("brown")
        ));
        Results results = new Results(List.of(new Result("꽝")), 1);

        assertThrows(IllegalArgumentException.class,
                () -> new GameResult(names, List.of(0, 1), results));
    }

    @Test
    void 존재하지_않는_참여자를_조회하면_예외가_발생한다() {
        Names names = new Names(List.of(new Name("neo")));
        Results results = new Results(List.of(new Result("꽝")), names.size());
        GameResult gameResult = new GameResult(names, List.of(0), results);

        assertThrows(IllegalArgumentException.class,
                () -> gameResult.findResult(new Name("brown")));
    }
}
