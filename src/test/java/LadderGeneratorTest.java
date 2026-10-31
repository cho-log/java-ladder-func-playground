import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void 인접한_가로선은_서로_겹치지_않는다() {
        LadderGenerator generator = new LadderGenerator();

        for (int attempt = 0; attempt < 100; attempt++) {
            Ladder ladder = generator.generate(new RowCount(4), new ColumnCount(4));
            assertNoOverlappingConnections(ladder);
        }
    }

    private void assertNoOverlappingConnections(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            assertNoOverlappingPoints(line.getPoints());
        }
    }

    private void assertNoOverlappingPoints(List<Connection> points) {
        for (int index = 1; index < points.size(); index++) {
            boolean overlapping = points.get(index - 1).isConnected()
                    && points.get(index).isConnected();
            assertFalse(overlapping);
        }
    }
}
