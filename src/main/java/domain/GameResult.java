package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GameResult {
    private final Map<Name, Result> results;

    public GameResult(NameResultPairs nameResultPairs, List<Integer> positions) {
        validateSize(nameResultPairs, positions);
        results = new LinkedHashMap<>();
        initializeResults(nameResultPairs, positions);
    }

    private void validateSize(NameResultPairs nameResultPairs, List<Integer> positions) {
        if (nameResultPairs == null || positions == null) {
            throw new IllegalArgumentException("결과 목록은 null일 수 없습니다.");
        }
        if (nameResultPairs.size() != positions.size()) {
            throw new IllegalArgumentException("참여자와 도착 위치의 개수가 일치해야 합니다.");
        }
    }

    private void initializeResults(NameResultPairs nameResultPairs, List<Integer> positions) {
        for (int index = 0; index < nameResultPairs.size(); index++) {
            addResult(nameResultPairs.getName(index), nameResultPairs.getResult(positions.get(index)));
        }
    }

    private void addResult(Name name, Result result) {
        if (name == null || result == null) {
            throw new IllegalArgumentException("이름 또는 결과가 유효하지 않습니다.");
        }
        results.put(name, result);
    }

    public Result findResult(Name name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
        return results.get(name);
    }

    public Set<Entry<Name, Result>> getResultEntries() {
        return Collections.unmodifiableMap(results).entrySet();
    }
}
