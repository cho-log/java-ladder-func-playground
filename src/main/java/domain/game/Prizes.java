package domain.game;

import domain.Position;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes createPrizes(List<String> inputPrizes) {
        List<Prize> prizes = inputPrizes.stream()
                .map(Prize::new)
                .toList();
        return new Prizes(prizes);
    }

    public Prize findPrize(Position endPosition) {
        return prizes.get(endPosition.getPosition());
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
