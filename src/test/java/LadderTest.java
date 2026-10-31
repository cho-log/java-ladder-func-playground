import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Connection;
import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리의_연결_상태를_정확하게_조회한다() {
        Line line = new Line(List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        ));
        Ladder ladder = new Ladder(List.of(line));

        assertTrue(ladder.isConnected(0, 0));
        assertFalse(ladder.isConnected(0, 1));
        assertTrue(ladder.isConnected(0, 2));
    }

    @Test
    void 사다리의_행과_열_개수를_정확하게_반환한다() {
        Line line = new Line(List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        ));
        Ladder ladder = new Ladder(List.of(line, line));

        assertEquals(2, ladder.getRow());
        assertEquals(4, ladder.getColumn());
    }

    @Test
    void 빈_라인_목록은_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ladder(List.of()));
    }

    @Test
    void null_라인_목록은_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ladder(null));
    }

    @Test
    void null이_포함된_라인_목록은_예외가_발생한다() {
        List<Line> lines = new ArrayList<>();
        lines.add(null);

        assertThrows(IllegalArgumentException.class,
                () -> new Ladder(lines));
    }

    @Test
    void 라인마다_연결_위치_개수가_다르면_예외가_발생한다() {
        Line firstLine = new Line(List.of(Connection.CONNECTED));
        Line secondLine = new Line(List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED
        ));

        assertThrows(IllegalArgumentException.class,
                () -> new Ladder(List.of(firstLine, secondLine)));
    }

}
