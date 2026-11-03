package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;

public class LadderGenerator {
    private final BooleanSupplier connectionStrategy;

    public LadderGenerator(BooleanSupplier connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public LadderGenerator() {
        this.connectionStrategy = new Random()::nextBoolean;
    }

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
            return createConnection();
        }
        return Connection.DISCONNECTED;
    }

    private Connection createConnection() {
        if (connectionStrategy.getAsBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}
