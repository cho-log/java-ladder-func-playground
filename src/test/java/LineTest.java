import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {
    @Test
    void 가로줄은_연속해서_연결되지_않는다() {
        // given
        Line line = new Line(4);

        // when
        List<Boolean> points = line.getPoints();

        // then
        for (int i = 0; i < points.size() - 1; i++) {
            boolean current = points.get(i);
            boolean next = points.get(i + 1);

            assertFalse(current && next);
        }
    }
}
