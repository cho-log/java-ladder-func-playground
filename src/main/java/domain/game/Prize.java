package domain.game;

import exception.ErrorMessage;

public class Prize {
    private final String prize;
    private Prize(String prize){
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(String prize){
        if (prize.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.PRIZE_IS_EMPTY.getMessage());
        }
    }

    public String getPrize() {
        return prize;
    }
}
