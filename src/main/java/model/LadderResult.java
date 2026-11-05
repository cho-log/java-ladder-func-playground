package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Name, Prize> ladderResults;

    public LadderResult(Map<Name, Prize> ladderResults) {
        this.ladderResults = Collections.unmodifiableMap(new LinkedHashMap<>(ladderResults));
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
