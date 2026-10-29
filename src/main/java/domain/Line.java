package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int CONNECTION_COUNT = 3;

    private final List<Connection> connections;

    public Line(ConnectionGenerator generator) {
        this.connections = createConnections(generator);
    }

    private List<Connection> createConnections(ConnectionGenerator generator) {
        List<Connection> connections = new ArrayList<>();
        Connection previous = Connection.DISCONNECTED;
        for (int index = 0; index < CONNECTION_COUNT; index++) {
            previous = previous.next(generator);
            connections.add(previous);
        }
        return List.copyOf(connections);
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
