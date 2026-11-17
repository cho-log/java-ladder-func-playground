package domain;

public class Participant {
    private final int start;
    private int end;

    public Participant(int start) {
        this.start = start;
        this.end = start;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void changeEnd(int end) {
        this.end = end;
    }
}
