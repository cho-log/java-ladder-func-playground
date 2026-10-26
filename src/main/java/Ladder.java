import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, int height) {
        this.lines = new ArrayList<>();
        generateLines(width, height );
    }

    private void generateLines(int width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
