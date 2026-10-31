package domain;

public class ResultQuery {
    private final String value;

    public ResultQuery(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("조회할 이름 또는 all을 입력해 주세요.");
        }
        this.value = value.trim();
    }

    public boolean isAll() {
        return value.equals("all");
    }

    public ParticipantName getName() {
        return new ParticipantName(value);
    }
}
