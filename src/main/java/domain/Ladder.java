package domain;

import domain.random.ConnectionGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createLadder(Width width, Height height, ConnectionGenerator connectionGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(Line.createLine(width, connectionGenerator));
        }
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

    public EndPositions findEndPositions(Width width) {
        List<Position> endPositions = new ArrayList<>();
        for (int i = 0; i <= width.connectionCount(); i++) {
            endPositions.add(findEndPosition(new Position(i)));
        }
        return new EndPositions(endPositions);
    }
}
