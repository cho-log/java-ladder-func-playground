package domain;

import exception.ErrorMessage;

public class Position {
    private static final int MINIMUM_POSITION = 0;
    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_IS_NEGATIVE.getMessage());
        }
    }

    public Position moveToRight() {
        return new Position(position + 1);
    }

    public Position moveToLeft() {
        return new Position(position - 1);
    }

    public int getPosition() {
        return position;
    }
}
