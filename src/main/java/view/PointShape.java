package view;

public enum PointShape {
    CONNECTED("-----"),
    EMPTY("     ");

    private final String shape;

    PointShape(String shape) {
        this.shape = shape;
    }

    public static String from(boolean point) {
        if (point) {
            return CONNECTED.shape;
        }
        return EMPTY.shape;
    }
}
