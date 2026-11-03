package domain;

import java.util.List;
import java.util.Objects;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        validateResults(results);
        this.results = List.copyOf(results);
    }

    private void validateResults(List<Result> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 최소 1개 이상이어야 합니다.");
        }
        validateNullResults(results);
    }

    private void validateNullResults(List<Result> results) {
        if (results.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("실행 결과에 null이 포함될 수 없습니다.");
        }
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
