package domain;

import java.util.List;

public class NameResultPairs {
    private final Names names;
    private final Results results;

    public NameResultPairs(Names names, Results results) {
        validatePairs(names, results);
        this.names = names;
        this.results = results;
    }

    private void validatePairs(Names names, Results results) {
        if (names == null || results == null) {
            throw new IllegalArgumentException("참여자와 실행 결과는 null일 수 없습니다.");
        }
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("참여자와 실행 결과의 개수가 일치해야 합니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public Name getName(int index) {
        return names.get(index);
    }

    public Result getResult(int index) {
        return results.get(index);
    }

    public List<Name> getNames() {
        return names.getNames();
    }

    public List<Result> getResults() {
        return results.getResults();
    }
}
