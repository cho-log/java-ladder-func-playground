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

    public static Ladder createLadder(int height, int width, ConnectionGenerator connectionGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createLine(width-1, connectionGenerator));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
