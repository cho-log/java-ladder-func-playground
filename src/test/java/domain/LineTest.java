package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Line line = new Line(points);

        // when
        Position destination = line.moveFrom(new Position(1));

        // then
        assertEquals(new Position(0), destination);
    }

    @Test
    void 오른쪽에_가로줄이_있으면_오른쪽으로_이동한다() {
        // given
        List<Boolean> points = List.of(false, true, false);
        Line line = new Line(points);

        // when
        Position destination = line.moveFrom(new Position(1));

        // then
        assertEquals(new Position(2), destination);
    }

    @Test
    void 양옆에_가로줄이_없으면_이동하지_않는다() {
        // given
        List<Boolean> points = List.of(false, false, false);
        Line line = new Line(points);

        // when
        Position destination1 = line.moveFrom(new Position(0));
        Position destination2 = line.moveFrom(new Position(1));
        Position destination3 = line.moveFrom(new Position(2));
        Position destination4 = line.moveFrom(new Position(3));

        // then
        assertEquals(new Position(0), destination1);
        assertEquals(new Position(1), destination2);
        assertEquals(new Position(2), destination3);
        assertEquals(new Position(3), destination4);
    }

    @Test
    void 위치가_사다리_범위를_벗어나면_예외가_발생한다() {
        // given
        List<Boolean> points = List.of(false, true, false);
        Line line = new Line(points);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> line.moveFrom(new Position(4)));
    }

    @Test
    void 두_Line의_넓이가_같은지_검사한다() {
        // given
        Line line = new Line(List.of(true, false, false));
        Line sameWidth = new Line(List.of(false, true, false));
        Line differentWidth = new Line(List.of(true, false));

        // when & then
        assertTrue(line.isSameWidth(sameWidth));
        assertFalse(line.isSameWidth(differentWidth));
    }
}
