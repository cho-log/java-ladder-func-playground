import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Connection;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 유효한_연결_상태로_라인을_생성한다() {
        List<Connection> points = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );

        Line line = new Line(points);

        assertEquals(points, line.getPoints());
    }

    @Test
    void 빈_연결_목록은_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Line(List.of()));
    }

    @Test
    void null_연결_목록은_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Line(null));
    }

    @Test
    void null이_포함된_연결_목록은_예외가_발생한다() {
        List<Connection> points = new ArrayList<>();
        points.add(Connection.CONNECTED);
        points.add(null);

        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }

    @Test
    void 인접한_가로선이_겹치면_예외가_발생한다() {
        List<Connection> points = List.of(
                Connection.CONNECTED,
                Connection.CONNECTED,
                Connection.DISCONNECTED
        );

        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }

}
