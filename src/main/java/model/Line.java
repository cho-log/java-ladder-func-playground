package model;

import java.util.ArrayList;
import java.util.List;
import model.generator.PointGenerator;

public class Line {
    private final Points points;

    public Line(int width, PointGenerator generator) {
        this.points = new Points(generateLine(width - 1, generator));
    }

    private List<Boolean> generateLine(int size, PointGenerator generator) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean prev = i > 0 && points.get(i - 1);
            points.add(!prev && generator.generate());
        }
        return points;
    }

    public int moveLine(int index) {
        if (points.hasPointAt(index - 1)) {
            return index - 1;
        }
        if (points.hasPointAt(index)) {
            return index + 1;
        }
        return index;
    }

    public List<Boolean> getLine() {
        return points.getPoints();
    }
}
