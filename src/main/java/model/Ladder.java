package model;

import java.util.ArrayList;
import java.util.List;
import model.generator.PointGenerator;

public class Ladder {
    private final List<Line> lines;
    private static final int MIN_WIDTH = 2;

    public Ladder(int width, Height height, PointGenerator generator) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }

        lines = new ArrayList<>();
        generateLines(height.getHeight(), width, generator);
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
