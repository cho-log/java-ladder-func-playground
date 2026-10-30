package domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validatePoints(points);
        this.points = List.copyOf(points);
    }

    private void validatePoints(List<Boolean> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(
                    "사다리 넓이는 2개 이상이여야 합니다."
            );
        }

        for (int i = 0; i < points.size() - 1; i++) {
            boolean current = points.get(i);
            boolean next = points.get(i + 1);

            validateAdjacentPoints(current, next);
        }
    }

    private void validateAdjacentPoints(boolean currentPoint, boolean nextPoint) {
        if (currentPoint && nextPoint) {
            throw new IllegalArgumentException(
                    "가로줄은 연속될 수 없습니다."
            );
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isSameWidth(Line other) {
        return points.size() == other.points.size();
    }

    public Position moveFrom(Position position) {
        validatePosition(position);

        if (position.getValue() == 0) {
            return moveRightIfConnected(position);
        }

        if (position.getValue() == points.size()) {
            return moveLeftIfConnected(position);
        }

        return moveHorizontally(position);
    }

    private void validatePosition(Position position) {
        if (position.getValue() > points.size()) {
            throw new IllegalArgumentException(
                    "위치가 사다리 범위를 벗어났습니다."
            );
        }
    }

    private Position moveLeftIfConnected(Position position) {
        if (points.get(position.getValue() - 1)) {
            return position.moveLeft();
        }

        return position;
    }

    private Position moveRightIfConnected(Position position) {
        if (points.get(position.getValue())) {
            return position.moveRight();
        }

        return position;
    }

    private Position moveHorizontally(Position position) {
        Position result = moveLeftIfConnected(position);

        if (!result.equals(position)) {
            return result;
        }

        return moveRightIfConnected(position);
    }
}
