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
}
