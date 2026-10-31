package domain;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
        this.value = value;
    }

    public Position move(Direction direction) {
        return new Position(direction.move(value));
    }

    public int getValue() {
        return value;
    }
}
