package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderResults {
    private final List<Position> destinations;

    public LadderResults(Width width, Ladder ladder) {
        this.destinations = calculateResult(width, ladder);
    }

    private List<Position> calculateResult(Width width, Ladder ladder) {
        List<Position> results = new ArrayList<>();

        for (int i = 0; i < width.getWidth(); i++) {
            Position start = new Position(i);
            results.add(ladder.findDestination(start));
        }

        return List.copyOf(results);
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
