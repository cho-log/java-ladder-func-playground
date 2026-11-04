package domain;

public class Prize {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Prize(String value) {
        validateLength(value);
        validateNotBlank(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validateNotBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 비어 있을 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 최대 " + MAXIMUM_LENGTH + "글자까지 가능합니다.");
        }
    }
}
