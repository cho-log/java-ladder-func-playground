package domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Connection> points;

    public Line(List<Connection> points) {
        validatePoints(points);
        this.points = List.copyOf(points);
    }

    private void validatePoints(List<Connection> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("연결 위치는 최소 1개 이상이어야 합니다.");
        }
        validateNullPoints(points);
        validateOverlapping(points);
    }

    private void validateNullPoints(List<Connection> points) {
        if (points.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("연결 상태에 null이 포함될 수 없습니다.");
        }
    }

    private void validateOverlapping(List<Connection> points) {
        for (int index = 1; index < points.size(); index++) {
            validateAdjacentPoints(points, index);
        }
    }

    private void validateAdjacentPoints(List<Connection> points, int index) {
        if (points.get(index - 1).isConnected() && points.get(index).isConnected()) {
            throw new IllegalArgumentException("인접한 가로선은 겹칠 수 없습니다.");
        }
    }

    public List<Connection> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public boolean isConnectedPoint(int index) {
        return points.get(index).isConnected();
    }

}
