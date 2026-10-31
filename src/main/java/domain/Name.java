package domain;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAXIMUM_LENGTH + "글자까지 가능합니다.");
        }
    }

    public String value() {
        return value;
    }
}
