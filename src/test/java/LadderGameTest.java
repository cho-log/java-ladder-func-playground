import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Connection;
import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    void 사다리의_시작점에_따라_올바른_도착점을_반환한다() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED)),
                new Line(List.of(Connection.DISCONNECTED, Connection.CONNECTED, Connection.DISCONNECTED)),
                new Line(List.of(Connection.CONNECTED, Connection.DISCONNECTED, Connection.DISCONNECTED)),
                new Line(List.of(Connection.DISCONNECTED, Connection.CONNECTED, Connection.DISCONNECTED))
        ));
        LadderGame game = new LadderGame(ladder);

        assertEquals(List.of(1, 2, 3, 0), game.getResult());
    }

    @Test
    void 최소_크기의_사다리에서_정상적으로_이동한다() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Connection.CONNECTED))
        ));
        LadderGame game = new LadderGame(ladder);

        assertEquals(List.of(1, 0), game.getResult());
    }

    @Test
    void null_사다리를_전달하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(null));
    }
}
