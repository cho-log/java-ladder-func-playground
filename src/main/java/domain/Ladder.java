package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int HEIGHT = 4;

    private final List<Line> lines;

    public Ladder(ConnectionGenerator generator) {
        this.lines = createLines(generator);
    }

    private List<Line> createLines(ConnectionGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int height = 0; height < HEIGHT; height++) {
            lines.add(new Line(generator));
        }
        return List.copyOf(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
