package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderResult {
    ArrayList<Integer> result;

    public LadderResult(Ladder ladder) {
        caculate(ladder);
    }

    private void caculate(Ladder ladder) {
        result = new ArrayList<>();
        for (int i = 0; i < ladder.getWidth(); i++) {
            result.add(ladder.move(i));
        }
    }

    public List<Integer> getResults() {
        return Collections.unmodifiableList(result);
    }
}
