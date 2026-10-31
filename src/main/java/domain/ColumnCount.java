package domain;

public class ColumnCount {
    private static final int MIN_COLUMN_COUNT = 2;

    private final int value;

    public ColumnCount(int value) {
        if (value < MIN_COLUMN_COUNT) {
            throw new IllegalArgumentException("열은 " + MIN_COLUMN_COUNT + " 이상이어야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
