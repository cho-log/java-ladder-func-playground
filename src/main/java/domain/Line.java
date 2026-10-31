package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Connection> connections;

    public Line(LadderWidth width, ConnectionGenerator generator) {
        this.connections = createConnections(width, generator);
    }

    private List<Connection> createConnections(LadderWidth width, ConnectionGenerator generator) {
        List<Connection> connections = new ArrayList<>();
        Connection previous = Connection.DISCONNECTED;
        for (int index = 0; index < width.getConnectionCount(); index++) {
            previous = previous.next(generator);
            connections.add(previous);
        }
        return List.copyOf(connections);
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public LadderWidth getWidth() {
        return new LadderWidth(connections.size() + 1);
    }

    public Position move(Position position) {
        validatePosition(position);
        if (isConnected(position.getValue() - 1)) {
            return position.move(Direction.LEFT);
        }
        if (isConnected(position.getValue())) {
            return position.move(Direction.RIGHT);
        }
        return position;
    }

    private boolean isConnected(int index) {
        return index >= 0 && index < connections.size()
                && connections.get(index) == Connection.CONNECTED;
    }

    private void validatePosition(Position position) {
        if (position.getValue() >= getWidth().getValue()) {
            throw new IllegalArgumentException("사다리 범위 안의 위치여야 합니다.");
        }
    }
}
