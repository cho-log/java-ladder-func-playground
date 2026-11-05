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
        return ladderResults.entrySet().stream()
                .filter(entry -> entry.getKey().isSameAs(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
    }

    public Map<Name, Prize> findAllResults() {
        return Collections.unmodifiableMap(ladderResults);
    }
}
