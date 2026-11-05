import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.ColumnCount;
import domain.Connection;
import domain.Ladder;
import domain.LadderGenerator;
import domain.Line;
import domain.RowCount;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

    @Test
    void 요청한_행과_열_개수에_맞게_사다리를_생성한다() {
        LadderGenerator generator = new LadderGenerator();
        Ladder ladder = generator.generate(new RowCount(4), new ColumnCount(4));

        assertEquals(4, ladder.getRow());
        assertEquals(4, ladder.getColumn());
    }

    @Test
    void 각_라인은_열_개수보다_하나_적은_연결_위치를_가진다() {
        LadderGenerator generator = new LadderGenerator();
        Ladder ladder = generator.generate(new RowCount(4), new ColumnCount(4));

        for (Line line : ladder.getLines()) {
            assertEquals(3, line.getPoints().size());
        }
    }

    @Test
    void 연결된_가로선_다음은_항상_끊긴다() {
        LadderGenerator generator = new LadderGenerator(() -> true);
        Ladder ladder = generator.generate(new RowCount(1), new ColumnCount(4));

        List<Connection> expected = List.of(
                Connection.CONNECTED,
                Connection.DISCONNECTED,
                Connection.CONNECTED);
        assertEquals(expected, ladder.getLines().get(0).getPoints());
    }

}
