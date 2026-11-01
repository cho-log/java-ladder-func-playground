package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Name, Prize> ladderResults;

    public LadderResult(Names names, Prizes prizes, Ladder ladder) {
        ladderResults = new LinkedHashMap<>();
        for (int i = 0; i < names.getSize(); i++) {
            ladderResults.put(names.get(i), prizes.get(ladder.move(i)));
        }
    }

    public Prize findResultOf(String name) {
        Name target = new Name(name);
        if (!ladderResults.containsKey(target)) {
            throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
        }
        return ladderResults.get(target);
    }

    public Map<Name, Prize> findAllResults() {
        return Collections.unmodifiableMap(ladderResults);
    }
}
