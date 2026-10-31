package domain;

public enum Connection {
    CONNECTED,
    NOT_CONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }
}
