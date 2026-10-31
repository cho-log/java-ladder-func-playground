package domain;

import domain.random.ConnectionGenerator;

public class FixedConnectionGenerator implements ConnectionGenerator {
    private final Connection connection;

    public FixedConnectionGenerator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection generate() {
        return connection;
    }
}
