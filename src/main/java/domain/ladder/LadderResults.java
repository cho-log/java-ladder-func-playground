package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {
    private final List<Position> destinations;

    public LadderResults(Width width, Ladder ladder) {
        this.destinations = calculateResult(width, ladder);
    }

    private List<Position> calculateResult(Width width, Ladder ladder) {
        return IntStream.range(0, width.getWidth())
                        .mapToObj(Position::new)
                        .map(ladder::findDestination)
                        .collect(Collectors.toUnmodifiableList());
    }

    public Position getDestination(Position start) {
        validatePosition(start);
        return destinations.get(start.getValue());
    }

    public int size() {
        return destinations.size();
    }

    private void validatePosition(Position start) {
        if (start.getValue() >= destinations.size()) {
            throw new IllegalArgumentException(
                    "시작 위치가 범위를 벗어났습니다."
            );
        }
    }
}
