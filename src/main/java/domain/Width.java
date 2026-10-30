package domain;

import exception.ErrorMessage;

public class Width {
    private static final int MINIMUM_WIDTH = 2;
    private final int width;

    public Width(int width){
        validateWidth(width);
        this.width = width;
    }

    private void validateWidth(int width){
        if (width < MINIMUM_WIDTH){
            throw new IllegalArgumentException(ErrorMessage.WIDTH_IS_BIGGER_THAN_2.getMessage());
        }
    }

    public int connectionCount() {
        return width - 1;
    }
}
