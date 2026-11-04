package domain;
import java.util.Objects;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateNotBlank(value);
        validateLength(value);
        this.value = value;
    }

    private void validateNotBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAXIMUM_LENGTH + "글자까지 가능합니다.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Name name)) {
            return false;
        }
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
