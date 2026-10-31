package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GameResult {
    private final Map<Name, Result> results;

    public GameResult(Names names, List<Integer> positions, Results gameResults) {
        validateSize(names, positions, gameResults);
        results = new LinkedHashMap<>();
        initializeResults(names, positions, gameResults);
    }

    private void validateSize(Names names, List<Integer> positions, Results gameResults) {
        if (names == null || positions == null || gameResults == null) {
            throw new IllegalArgumentException("결과 목록은 null일 수 없습니다.");
        }
        if (names.size() != positions.size() || names.size() != gameResults.size()) {
            throw new IllegalArgumentException("이름과 결과의 개수가 일치해야 합니다.");
        }
    }

    private void initializeResults(Names names, List<Integer> positions, Results gameResults) {
        for (int index = 0; index < names.size(); index++) {
            addResult(names.get(index), gameResults.get(positions.get(index)));
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
