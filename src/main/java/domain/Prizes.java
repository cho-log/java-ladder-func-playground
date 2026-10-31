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
        for (String value : input.split(",")) {
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
