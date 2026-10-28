import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;
    private final Random random = new Random();

    public Line(int width) {
        this.points = new ArrayList<>();
        generatePoints(width - 1);
    }

    private void generatePoints(int pointCount) {
        for (int i = 0; i < pointCount; i++) {
            boolean point = generatePoint();
            points.add(point);
        }
    }

    private boolean generatePoint() {
        if (points.isEmpty()) {
            return random.nextBoolean();
        }

        if (points.get(points.size() - 1)) {
            return false;
        }

        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
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
