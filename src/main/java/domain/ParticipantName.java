package domain;

public class ParticipantName {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public ParticipantName(String value) {
        String name = value.trim();
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH || name.equals("all")) {
            throw new IllegalArgumentException("이름은 all을 제외한 1~5글자여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ParticipantName)) {
            return false;
        }
        return value.equals(((ParticipantName) other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
