package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        validateLadder(ladder);
        this.ladder = ladder;
    }

    private void validateLadder(Ladder ladder) {
        if (ladder == null) {
            throw new IllegalArgumentException("사다리는 null일 수 없습니다.");
        }
    }

    public List<Integer> getResult() {
        return IntStream.range(0, ladder.getColumn())
                .map(ladder::move)
                .boxed()
                .toList();
    }

}
