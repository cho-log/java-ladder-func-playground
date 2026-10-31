package domain.ladder;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderResultsTest {
    @Test
    void 시작_위치에_대한_도착_위치를_반환한다() {
        // given
        List<Connection> line1 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );
        List<Connection> line2 = List.of(
                Connection.DISCONNECTED,
                Connection.CONNECTED,
                Connection.DISCONNECTED
        );

        List<Line> lines = List.of(
                new Line(line1),
                new Line(line2)
        );

        Ladder ladder = new Ladder(lines);

        LadderResults results = new LadderResults(new Width(4), ladder);

        // when & then
        assertEquals(new Position(2), results.getDestination(new Position(0)));
        assertEquals(new Position(0), results.getDestination(new Position(1)));
        assertEquals(new Position(3), results.getDestination(new Position(2)));
        assertEquals(new Position(1), results.getDestination(new Position(3)));
    }

    @Test
    void 시작_위치가_사다리_범위를_넘어가면_예외가_발생한다() {
        // given
        List<Connection> line1 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );
        List<Connection> line2 = List.of(
                Connection.DISCONNECTED,
                Connection.CONNECTED,
                Connection.DISCONNECTED
        );

        List<Line> lines = List.of(
                new Line(line1),
                new Line(line2)
        );

        Ladder ladder = new Ladder(lines);

        LadderResults results = new LadderResults(new Width(3), ladder);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> results.getDestination(new Position(4)));
    }
}
