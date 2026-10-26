package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderResult play() {//사다리를 타고 내려간 최종 위치들을 반환
        List<Position> arrivals = new ArrayList<>();
        for (Position start : ladder.startPositions()) { //사다리의 시작 위치들을 순회하면서 사다리를 타고 내려간 최종 위치를 구한다.
            arrivals.add(ladder.climb(start)); //사다리를 타고 내려간 최종 위치를 반환
        }
        return new LadderResult(arrivals); //사다리를 타고 내려간 최종 위치들을 담은 LadderResult 객체를 반환
    }
}
