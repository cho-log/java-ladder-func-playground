public class Width {
    private final int width;

    public Width(int width) {
        validate(width);
        this.width = width;
    }

    private void validate(int width) {
        if (width < 2) {
            throw new IllegalArgumentException(
                    "사다리 넓이는 최소 2개여야 합니다."
            );
        }
    }

    public int getWidth() {
        return width;
    }
}
