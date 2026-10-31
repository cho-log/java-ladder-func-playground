package domain;

import java.util.Random;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private final Random random = new Random();

    @Override
    public Connection generate() {
        return Connection.from(random.nextBoolean());
    }
}
