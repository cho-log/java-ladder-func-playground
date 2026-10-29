package domain;

public class Outcome {
    private final String value;

    public Outcome(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 비어 있을 수 없습니다.");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }
}
