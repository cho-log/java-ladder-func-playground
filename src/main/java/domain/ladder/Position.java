package domain.ladder;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    "위치는 0 이상이여야 합니다."
            );
        }
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    public Position moveRight() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Position)) {
            return false;
        }
        Position position = (Position) object;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
