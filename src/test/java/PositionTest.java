import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {
    @Test
    void 위치가_0보다_작으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @Test
    void 위치는_0보다_커야한다() {
        assertEquals(1, new Position(1).getValue());
    }

    @Test
    void 왼쪽으로_한_칸_이동한다() {
        // given
        Position position = new Position(4);

        // when
        Position result = position.moveLeft();

        // then
        assertEquals(3, result.getValue());
        assertEquals(4, position.getValue());
    }

    @Test
    void 위치가_0일때_왼쪽으로_이동하면_예외가_발생한다() {
        // given
        Position position = new Position(0);

        // when & then
        assertThrows(IllegalArgumentException.class, position::moveLeft);
    }

    @Test
    void 오른쪽으로_한_칸_이동한다() {
        // given
        Position position = new Position(4);

        // when
        Position result = position.moveRight();

        // then
        assertEquals(5, result.getValue());
        assertEquals(4, position.getValue());
    }

    @Test
    void 위치값이_같으면_동등하다() {
        Position position1 = new Position(4);
        Position position2 = new Position(4);

        assertEquals(position1, position2);
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    void 위치값이_다르면_동등하지_않다() {
        Position position1 = new Position(3);
        Position position2 = new Position(4);

        assertNotEquals(position1, position2);
    }
}
