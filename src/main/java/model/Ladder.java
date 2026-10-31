package model;

import java.util.ArrayList;
import java.util.List;
import model.generator.PointGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, int height, PointGenerator generator) {
        lines = new ArrayList<>();
        generateLines(height, width, generator);
    }

    private void generateLines(int height, int width, PointGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, generator));
        }
    }

    public int move(int position) {

        for (Line line : lines) {
            position = line.moveLine(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

}
