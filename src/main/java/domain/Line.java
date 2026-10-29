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
}
