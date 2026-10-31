package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private static final Random RANDOM = new Random();

    public Ladder generate(RowCount row, ColumnCount column) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < row.getValue(); i++) {
            lines.add(new Line(initializePoints(column.getValue() - 1)));
        }
        return new Ladder(lines);
    }

    private List<Connection> initializePoints(int count) {
        List<Connection> points = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            points.add(createPoint(points, i));
        }
        return points;
    }

    private Connection createPoint(List<Connection> points, int index) {
        if (index == 0 || !points.get(index - 1).isConnected()) {
            return createRandomConnection();
        }
        return Connection.DISCONNECTED;
    }

    private Connection createRandomConnection() {
        if (RANDOM.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}
