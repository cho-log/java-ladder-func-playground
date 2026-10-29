package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LadderWidth width, LadderHeight height, ConnectionGenerator generator) {
        this.lines = createLines(width, height, generator);
    }

    private List<Line> createLines(LadderWidth width, LadderHeight height, ConnectionGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height.getValue(); index++) {
            lines.add(new Line(width, generator));
        }
        return List.copyOf(lines);
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
        List<LadderPath> paths = new ArrayList<>();
        for (int start = 0; start < lines.get(0).getWidth().getValue(); start++) {
            Position position = new Position(start);
            paths.add(new LadderPath(position, move(position)));
        }
        return List.copyOf(paths);
    }
}
