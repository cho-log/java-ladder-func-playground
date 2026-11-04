package domain;

import domain.random.ConnectionGenerator;
import exception.ErrorMessage;
import java.util.Collections;
import java.util.List;
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

    public int width() {
        return lines.get(0).width();
    }

    public Position findEndPosition(Position position) {
        validateInLadder(position);
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    private void validateInLadder(Position position) {
        if (position.getPosition() >= width()) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_OUT_OF_LADDER.getMessage());
        }
    }
}
