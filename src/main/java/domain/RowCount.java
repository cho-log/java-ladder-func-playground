package domain;

public class RowCount {
    private static final int MIN_ROW_COUNT = 1;

    private final int value;

    public RowCount(int value) {
        if (value < MIN_ROW_COUNT) {
            throw new IllegalArgumentException("행은 " + MIN_ROW_COUNT + " 이상이어야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
