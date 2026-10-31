package domain;

import java.util.List;

class FixedConnectionGenerator implements ConnectionGenerator {
    private final List<Connection> connections;
    private int index;

    FixedConnectionGenerator(List<Connection> connections) {
        this.connections = List.copyOf(connections);
    }

    @Override
    public Connection generate() {
        Connection connection = connections.get(index);
        index++;
        return connection;
    }
}
