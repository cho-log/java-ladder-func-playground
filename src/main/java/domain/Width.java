package domain;

import exception.ErrorMessage;

public class Width {
    private static final int MINIMUM_WIDTH = 2;
    private final int width;

    public Width(int width) {
        validateWidth(width);
        this.width = width;
    }

    private void validateWidth(int width) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_WIDTH.getMessage());
        }
    }

    public int connectionCount() {
        return width - 1;
    }

    public int getWidth() {
        return width;
    }
}
