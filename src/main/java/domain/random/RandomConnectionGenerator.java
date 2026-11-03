package domain.random;

import domain.Connection;
import java.util.Random;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private final Random random;

    public RandomConnectionGenerator(Random random) {
        this.random = random;
    }

    @Override
    public Connection generate() {
        if (random.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.NOT_CONNECTED;
    }
}
