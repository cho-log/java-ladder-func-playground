package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectionGenerator {
    private final Random random = new Random();

    public List<Connection> generatePoints(Width width) {
        List<Connection> points = new ArrayList<>();
        int pointCount = width.getConnectionSlotCount();

        for (int i = 0; i < pointCount; i++) {
            Connection point = generatePoint(points);
            points.add(point);
        }

        return List.copyOf(points);
    }

    private Connection generatePoint(List<Connection> points) {
        if (points.isEmpty()) {
            boolean randomBoolean = random.nextBoolean();
            return returnConnection(randomBoolean);
        }

        if (points.get(points.size() - 1).isConnected()) {
            return Connection.DISCONNECTED;
        }

        boolean randomBoolean = random.nextBoolean();
        return returnConnection(randomBoolean);
    }

    private Connection returnConnection(boolean connected) {
        if (connected) {
            return Connection.CONNECTED;
        }
        return Connection.DISCONNECTED;
    }
}
