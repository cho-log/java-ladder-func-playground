package domain;

public class LadderPath {
    private final Position start;
    private final Position end;

    public LadderPath(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }
}
