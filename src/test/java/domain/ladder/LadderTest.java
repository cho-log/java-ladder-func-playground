package domain.ladder;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderTest {
    @Test
    void 사다리_높이가_0인_경우_예외가_발생한다() {
        // given
        List<Line> lines = List.of();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Ladder(lines));
    }

    @Test
    void 사다리_넓이가_서로_다르면_예외가_발생한다() {
        // given
        List<Connection> line1 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );
        List<Connection> line2 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED
        );

        List<Line> lines = List.of(
                new Line(line1),
                new Line(line2)
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Ladder(lines));
    }

    @Test
    void 유효한_Line_정보로_사다리를_생성한다() {
        // given
        List<Connection> line1 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );
        List<Connection> line2 = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED
        );

        List<Line> lines = List.of(
                new Line(line1),
                new Line(line2)
        );

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertEquals(lines, ladder.getLines());
    }

    @Test
    void 출발점에서_도착점을_찾는다() {
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

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertEquals(new Position(2), ladder.findDestination(new Position(0)));
        assertEquals(new Position(0), ladder.findDestination(new Position(1)));
        assertEquals(new Position(3), ladder.findDestination(new Position(2)));
        assertEquals(new Position(1), ladder.findDestination(new Position(3)));
    }
}
