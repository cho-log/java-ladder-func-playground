import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.NameResultPairs;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Results;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameResultPairsTest {

    @Test
    void 참여자와_실행_결과의_개수가_다르면_예외가_발생한다() {
        Names names = new Names(List.of(new Name("neo"), new Name("brown")));
        Results results = new Results(List.of(new Result("꽝")));

        assertThrows(IllegalArgumentException.class,
                () -> new NameResultPairs(names, results));
    }
}
