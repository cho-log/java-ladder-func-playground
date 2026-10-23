package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Ladder는 사다리전체를 의미하며(가로줄 N개를 모은것)
public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(LadderSize height, LadderSize width, BooleanGenerator booleanGenerator) {
        width = toPointCount(width); //세로줄 개수(넓이)를 칸 개수로 바꾼다.
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height.value(); index++) {
            lines.add(Line.create(width, booleanGenerator));
        }
        return new Ladder(lines);
    }

    private static LadderSize toPointCount(LadderSize width) { //세로줄 개수(넓이)를 칸 개수로 바꾼다.
        return new LadderSize(width.value() - 1);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
