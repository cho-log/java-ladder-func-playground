import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Results;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @Test
    void 실행_결과가_비어_있으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new Results(List.of()));
    }
}
