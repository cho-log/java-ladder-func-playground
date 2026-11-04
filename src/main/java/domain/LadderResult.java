package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//LadderResult는 사다리를 타고 내려간 최종 위치들을 담는 클래스 이것도 포장해서 의미파악쉽게
public class LadderResult {
    private final List<Position> arrivals;

    public LadderResult(List<Position> arrivals) {
        this.arrivals = new ArrayList<>(arrivals);
    }

    public List<Position> arrivals() {
        return Collections.unmodifiableList(arrivals);
    }
}