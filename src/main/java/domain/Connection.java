package domain;

public enum Connection {
    CONNECTED,
    DISCONNECTED;

    public static Connection from(boolean connected) {
        if (connected) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public Connection next(ConnectionGenerator generator) {
        if (this == CONNECTED) {
            return DISCONNECTED;
        }
        return generator.generate();
    }
}
