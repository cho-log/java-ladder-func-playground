import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Result;
import domain.Results;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @Test
    void 실행_결과가_비어_있으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new Results(List.of(), 0));
    }

    @Test
    void 참여자와_실행_결과의_개수가_다르면_예외가_발생한다() {
        List<Result> results = List.of(new Result("꽝"));

        assertThrows(IllegalArgumentException.class,
                () -> new Results(results, 2));
    }
}
