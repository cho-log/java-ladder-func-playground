package domain.game;

import domain.Position;
import domain.Width;
import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes, Width width) {
        validatePrize(prizes, width);
        this.prizes = prizes;
    }

    public static Prizes createPrizes(List<String> inputPrizes, Width width) {
        List<Prize> prizes = new ArrayList<>();
        for (String inputPrize : inputPrizes) {
            prizes.add(new Prize(inputPrize));
        }
        return new Prizes(prizes, width);
    }

    private void validatePrize(List<Prize> prizes, Width width) {
        if (width.getWidth() != prizes.size()) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_IS_NOT_NAME_NUMBER.getMessage());
        }
    }

    public Prize findPrize(Position endPosition) {
        return prizes.get(endPosition.getPosition());
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
