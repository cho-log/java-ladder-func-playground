package model;

import java.util.List;

public class Points {
    private final List<Boolean> points;

    public Points(List<Boolean> points) {
        validateNoConsecutive(points);
        this.points = List.copyOf(points);
    }

    private void validateNoConsecutive(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1) && points.get(i)) {
                throw new IllegalArgumentException("다리는 연속될 수 없습니다.");
            }
        }
    }

    public boolean hasPointAt(int index) {
        return index >= 0 && index < points.size() && points.get(index);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}


