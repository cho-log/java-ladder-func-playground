package domain;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < ladder.getColumn(); i++) {
            resultList.add(ladder.move(i));
        }
        return resultList;
    }

}
