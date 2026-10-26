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

    public Position climb(Position position) { //position을 받아서 사다리를 타고 내려간 최종 위치를 반환
        for (Line line : lines) { //사다리의 각 가로줄을 순회하면서 현재 위치에서 이동한 위치를 반환
            position = line.move(position); //현재위치에서 이동한 위치를 반환
        }
        return position; //사다리의 마지막 가로줄까지 내려간 최종 위치를 반환
    }

    public List<Position> startPositions() {
        List<Position> positions = new ArrayList<>(); //사다리의 시작 위치들을 담는 리스트
        for (int index = 0; index < startCount(); index++) { //사다리의 시작 위치 개수만큼 반복하면서 Position 객체를 생성하여 리스트에 추가
            positions.add(new Position(index));
        }
        return positions; //사다리의 시작 위치들을 담은 리스트를 반환
    }

    private int startCount() {
        return lines.get(0).points().size() + 1; //사다리의 시작 위치 개수는 첫번째 가로줄의 칸 개수 + 1 ==  세로줄의 갯수
    }
}
