package domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
        // true/false 중 하나를 랜덤으로 뽑아서 반환
    }

}
