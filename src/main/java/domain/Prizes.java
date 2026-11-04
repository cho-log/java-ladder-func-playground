package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(String input) {
        List<Prize> prizes = new ArrayList<>();
        for (String value : input.split(",", -1)) { // names와 마찬가지로 -1을 추가하여 끝의 빈값도 버리지않게 처리함.
            prizes.add(new Prize(value.trim()));
        }
        return new Prizes(prizes);
    }

    public int size() {
        return prizes.size();
    }

    public List<Prize> prizes() {
        return Collections.unmodifiableList(prizes);
    }

}
