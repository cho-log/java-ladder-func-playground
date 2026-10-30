package domain.ladder;

public enum Connection {
    CONNECTED,
    DISCONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }
}
