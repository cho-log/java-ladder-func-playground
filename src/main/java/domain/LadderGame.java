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
            resultList.add(playGame(i));
        }
        return resultList;
    }

    private int playGame(int position) {
        for (int row = 0; row < ladder.getRow(); row++) {
            position = move(row, position);
        }
        return position;
    }

    private int move(int row, int position) {
        if (canMoveLeft(row, position)) {
            return position - 1;
        }
        if (canMoveRight(row, position)) {
            return position + 1;
        }
        return position;
    }

    private boolean canMoveLeft(int row, int position) {
        if (position == 0) {
            return false;
        }
        return ladder.isConnected(row, position - 1);
    }

    private boolean canMoveRight(int row, int position) {
        if (position == ladder.getColumn() - 1) {
            return false;
        }
        return ladder.isConnected(row, position);
    }
}
