package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<String, String> ladderResults;

    public LadderResult(Names names, Prizes prizes, Ladder ladder) {
        ladderResults = new LinkedHashMap<>();
        List<String> nameList = names.getNames();
        List<String> prizeList = prizes.getPrizes();
        for (int i = 0; i < nameList.size(); i++) {
            int end = ladder.move(i);
            ladderResults.put(nameList.get(i), prizeList.get(end));
        }
    }

    public String findResultOf(String name) {
        if (!ladderResults.containsKey(name)) {
            throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
        }
        return ladderResults.get(name);
    }

    public Map<String, String> findAllResults() {
        return Collections.unmodifiableMap(ladderResults);
    }
}
