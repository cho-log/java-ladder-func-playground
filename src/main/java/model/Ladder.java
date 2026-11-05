package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.generator.PointGenerator;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;

    public Ladder(int width, Height height, PointGenerator generator) {
        this.lines=generateLines(height.getHeight(), width, generator);
    }

    private List<Line> generateLines(int height, int width, PointGenerator generator) {
        List<Line> lines=new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, generator));
        }
        return List.copyOf(lines);
    }

    public int move(int position) {

        for (Line line : lines) {
            position = line.moveLine(position);
        }
        return position;
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
