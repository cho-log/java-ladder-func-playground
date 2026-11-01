package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prize);
    }
}
