package domain;

public class Result {
    private final String value;

    public Result(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("결과는 비어 있을 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
