package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
        validateLines(lines);
    }

    private void validateLines(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(
                    "사다리 높이는 1개 이상이여야 합니다."
            );
        }

        for (Line line : lines) {
            validateLine(line);
        }
    }

    private void validateLine(Line line) {
        if (!lines.get(0).isSameWidth(line)) {
            throw new IllegalArgumentException(
                    "사다리 넓이는 모두 같아야 합니다."
            );
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public Position findDestination(Position position) {
        for (Line line : lines) {
            position = line.moveFrom(position);
        }

        return position;
    }
}
