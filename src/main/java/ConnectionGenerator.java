import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectionGenerator {
    private final Random random = new Random();

    public List<Boolean> generatePoints(Width width) {
        List<Boolean> points = new ArrayList<>();
        int pointCount = width.getConnectionSlotCount();

        for (int i = 0; i < pointCount; i++) {
            boolean point = generatePoint(points);
            points.add(point);
        }

        return List.copyOf(points);
    }

    private boolean generatePoint(List<Boolean> points) {
        if (points.isEmpty()) {
            return random.nextBoolean();
        }

        if (points.get(points.size() - 1)) {
            return false;
        }

        return random.nextBoolean();
    }
}
