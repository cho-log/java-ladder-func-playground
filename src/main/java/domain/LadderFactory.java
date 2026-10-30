package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private final ConnectionGenerator connectionGenerator;

    public LadderFactory(ConnectionGenerator connectionGenerator) {
        this.connectionGenerator = connectionGenerator;
    }

    public Ladder createLadder(Width width, Height height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(connectionGenerator.generatePoints(width)));
        }

        return new Ladder(lines);
    }
}
