import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final ConnectionGenerator connectionGenerator;

    public Ladder(Width width, Height height) {
        this.lines = new ArrayList<>();
        this.connectionGenerator = new ConnectionGenerator();
        generateLines(width, height.getHeight());
    }

    private void generateLines(Width width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(connectionGenerator.generatePoints(width)));
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public int findDestination(int position) {
        for (Line line : lines) {
            position = line.moveFrom(position);
        }

        return position;
    }
}
