package model;

import java.util.ArrayList;
import java.util.List;
import model.generator.PointGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(int width, PointGenerator generator) {
        points = new ArrayList<>();
        generateLine(width - 1, generator);
    }

    private void generateLine(int width, PointGenerator generator) {
        for (int i = 0; i < width; i++) {
            addPoint(i, generator);
        }
    }

    private void addPoint(int index, PointGenerator generator) {
        if (index > 0 && points.get(index - 1)) {
            points.add(false);
            return;
        }
        points.add(generator.generate());
    }

    public int moveLine(int index) {
        if (index > 0 && points.get(index - 1)) {
            return index - 1;
        }
        if (index < points.size() && points.get(index)) {
            return index + 1;
        }
        return index;
    }

    public List<Boolean> getLine() {
        return List.copyOf(points);
    }
}
