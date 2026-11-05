package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final LadderResult ladderResult;

    public LadderGame(Names names, Prizes prizes, Ladder ladder) {
        validateGame(names, prizes, ladder);
        this.ladderResult = new LadderResult(start(names, prizes, ladder));

    }

    private void validateGame(Names names, Prizes prizes, Ladder ladder) {
        if (names.getParticipantCount() != prizes.getSize()) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야 합니다.");
        }
        if (names.getParticipantCount() != ladder.getWidth()) {
            throw new IllegalArgumentException("사다리 너비는 참가자 수와 같아야 합니다.");
        }
    }

    private Map<Name, Prize> start(Names names, Prizes prizes, Ladder ladder) {
        Map<Name, Prize> results = new LinkedHashMap<>();
        for (int start = 0; start < names.getParticipantCount(); start++) {
            int end = ladder.move(start);
            results.put(names.get(start), prizes.get(end));
        }
        return results;
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
