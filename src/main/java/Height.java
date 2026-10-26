public class Height {
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(
                    "사다리 높이는 최소 1개여야 합니다."
            );
        }
    }

    public int getHeight() {
        return height;
    }
}
