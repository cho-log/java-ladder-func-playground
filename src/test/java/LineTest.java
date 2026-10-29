import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {
    @Test
    void 유효한_가로줄로_Line을_생성한다() {
        // given
        List<Boolean> points = List.of(true, false, true);

        // when
        Line line = new Line(points);

        // then
        assertEquals(points, line.getPoints());
    }

    @Test
    void 가로줄이_연속이면_예외가_발생한다() {
        // given
        List<Boolean> points = List.of(true, true, false);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }

    @Test
    void 가로줄이_비어있으면_예외가_발생한다() {
        // given
        List<Boolean> points = List.of();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }

    @Test
    void 왼쪽에_가로줄이_있으면_왼쪽으로_이동한다() {
        // given
        List<Boolean> points = List.of(true, false, true);

        // when
        Line line = new Line(points);

        // then
        assertEquals(0, line.moveFrom(1));
        assertEquals(2, line.moveFrom(3));
    }

    @Test
    void 오른쪽에_가로줄이_있으면_오른쪽으로_이동한다() {
        // given
        List<Boolean> points = List.of(true, false, true);

        // when
        Line line = new Line(points);

        // then
        assertEquals(1, line.moveFrom(0));
        assertEquals(3, line.moveFrom(2));
    }

    @Test
    void 양옆에_가로줄이_없으면_이동하지_않는다() {
        // given
        List<Boolean> points = List.of(false, false, false);

        // when
        Line line = new Line(points);

        // then
        assertEquals(0, line.moveFrom(0));
        assertEquals(1, line.moveFrom(1));
        assertEquals(2, line.moveFrom(2));
        assertEquals(3, line.moveFrom(3));
    }
}
