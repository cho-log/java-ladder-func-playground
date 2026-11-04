package domain;

// int 값의 포장을 위해 만듬 <사다리의 크기 >
public class LadderSize {
    private static final int MINIMUM_SIZE = 1;

    private final int value;

    public LadderSize(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_SIZE) {
            throw new IllegalArgumentException("사다리 크기는 " + MINIMUM_SIZE + " 이상이어야 합니다.");
        }
    }

    public int value() {
        return value;
    }
}
