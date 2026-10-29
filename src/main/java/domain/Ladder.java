package domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LadderWidth width, LadderHeight height, ConnectionGenerator generator) {
        this.lines = createLines(width, height, generator);
    }

    private List<Line> createLines(LadderWidth width, LadderHeight height, ConnectionGenerator generator) {
        return Stream.generate(() -> new Line(width, generator))
                .limit(height.getValue())
                .toList();
    }

    public List<Line> getLines() {
        return lines;
    }

    public Position move(Position start) {
        Position current = start;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<LadderPath> getPaths() {
        return IntStream.range(0, lines.get(0).getWidth().getValue())
                .mapToObj(Position::new)
                .map(start -> new LadderPath(start, move(start)))
                .toList();
    }
}
