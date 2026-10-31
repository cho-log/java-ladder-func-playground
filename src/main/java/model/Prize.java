package model;

public class Prize {
    private final String prize;

    public Prize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    private void validate(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 비어 있을 수 없습니다.");
        }
    }

    public String getPrize() {
        return prize;
    }
}
