package domain;

public enum Direction {
    LEFT(-1),
    STAY(0),
    RIGHT(1);

    private final int movement;

    Direction(int movement) {
        this.movement = movement;
    }

    public int move(int position) {
        return position + movement;
    }
}
