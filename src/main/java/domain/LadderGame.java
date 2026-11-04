package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderResult play() {
        List<Position> arrivals = ladder.startPositions().stream() //사다리의 시작 위치들을 순회하면서 각 위치에서 사다리를 타고 내려간 최종 위치를 구한다.
                .map(ladder::climb) //각 시작 위치에서 사다리를 타고 내려간 최종 위치를 구한다.
                .toList(); //각 시작 위치에서 사다리를 타고 내려간 최종 위치들을 리스트로 모은다.
        return new LadderResult(arrivals); //각 시작 위치에서 사다리를 타고 내려간 최종 위치들을 담은 LadderResult 객체를 생성하여 반환한다.
    }

}
