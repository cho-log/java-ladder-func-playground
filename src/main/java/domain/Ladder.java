package domain;

import domain.random.ConnectionGenerator;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createLadder(Width width, Height height, ConnectionGenerator connectionGenerator) {
        List<Line> lines = Stream.generate(() -> Line.createLine(width, connectionGenerator))
                .limit(height.getHeight())
                .toList();
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private Position findEndPosition(Position position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public EndPositions findEndPositions() {
        List<Position> endPositions = IntStream.range(0, lines.get(0).width())
                .mapToObj(Position::new)
                .map(this::findEndPosition)
                .toList();
        return new EndPositions(endPositions);
    }
}
