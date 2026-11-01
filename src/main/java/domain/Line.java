package domain;

import domain.random.ConnectionGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 사다리의 가로 한 줄을 나타내는 클래스
 */

public class Line {
    private final List<Connection> connections;

    private Line(List<Connection> connections) {
        this.connections = connections;
    }

    public static Line createLine(Width width, ConnectionGenerator generator) {
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < width.connectionCount(); i++) {
            connections.add(nextConnection(connections, generator));
        }
        return new Line(connections);
    }

    private static Connection nextConnection(List<Connection> connections, ConnectionGenerator generator) {
        if (isPreviousConnected(connections)) {
            return Connection.NOT_CONNECTED;
        }
        return generator.generate();
    }

    private static boolean isPreviousConnected(List<Connection> connections) {
        if (connections.isEmpty()) {
            return false;
        }
        return connections.get(connections.size() - 1).isConnected();
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public Position move(Position position) {
        if (isRightConnected(position)) {
            return position.moveToRight();
        }

        if (isLeftConnected(position)) {
            return position.moveToLeft();
        }

        return position;
    }

    private boolean isRightConnected(Position position) {
        int rightIndex = position.getPosition();
        if (rightIndex >= connections.size()) {
            return false;
        }
        return connections.get(rightIndex).isConnected();
    }

    private boolean isLeftConnected(Position position) {
        int leftIndex = position.getPosition() - 1;
        if (leftIndex < 0) {
            return false;
        }
        return connections.get(leftIndex).isConnected();
    }
}
