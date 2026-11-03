package domain.ladder;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private final int value;

    public LadderHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
