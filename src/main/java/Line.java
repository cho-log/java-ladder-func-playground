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

    public int moveFrom(int position) {
        if (position == 0) {
            return moveRightIfConnected(position);
        }

        if (position == points.size()) {
            return moveLeftIfConnected(position);
        }

        return moveHorizontally(position);
    }

    private int moveLeftIfConnected(int position) {
        if (points.get(position - 1)) {
            return position - 1;
        }

        return position;
    }

    private int moveRightIfConnected(int position) {
        if (points.get(position)) {
            return position + 1;
        }

        return position;
    }

    private int moveHorizontally(int position) {
        int result = moveLeftIfConnected(position);

        if (result != position) {
            return result;
        }

        return moveRightIfConnected(position);
    }
}
