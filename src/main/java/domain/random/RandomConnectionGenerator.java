package domain.random;

import domain.Connection;
import java.util.Random;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private final Random random = new Random();

    @Override
    public Connection generate() {
        if (random.nextBoolean()) {
            return Connection.CONNECTED;
        }
        return Connection.NOT_CONNECTED;
    }
}
