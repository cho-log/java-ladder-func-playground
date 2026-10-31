package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Line은 가로 한줄을 의미하며, 칸과 각 칸의 연결여부를 담고있다.
public class Line {

    private final List<Point> points; // 한 줄에 칸 3개와 각 칸의 연결여부를 담고있는칸.

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(LadderSize width, BooleanGenerator booleanGenerator) {
        List<Point> points = new ArrayList<>();
        //칸을 width개  만들어서 Line으로 완성
        for (int index = 0; index < width.value(); index++) {
            points.add(nextPoint(points, booleanGenerator)); //다음칸을 정해주는데 앞이 연결일경우 끊게 하고 아니면 랜덤배정
        }
        return new Line(points);
    }

    //nextPoint()는 다음칸을 정해주는데 앞이 연결일경우 끊게 하고 아니면 랜덤배정
    private static Point nextPoint(List<Point> points, BooleanGenerator booleanGenerator) {
        if (isPreviousPointConnected(points)) { //바로 앞칸이 연결인지 확인
            return Point.disconnected(); //직전이 연결이면 이번칸은 연결이 아니게 끊는다.
        }
        return randomPoint(booleanGenerator); //직전이 연결이 아니면 이번칸은 랜덤으로 연결여부를 결정한다.
    }

    private static boolean isPreviousPointConnected(List<Point> points) { //바로 앞칸이 연결인지 확인
        if (points.isEmpty()) {
            return false;                      // 첫 칸은 직전이 없으니 연결 아님
        }
        return points.get(points.size() - 1).isConnected();
    }


    //randomPoint()는 BooleanGenerator로 연결 여부를 결정한다 true,false 중 하나를 랜덤으로 뽑아서 반환
    private static Point randomPoint(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return Point.connected();
        }
        return Point.disconnected();
    }

    public List<Point> points() { // points를 반환하는데 외부에서 수정하지 못하게 unmodifiableList로 감싸서 반환
        return Collections.unmodifiableList(points);
    }


    public Position move(Position position) { //position을 받아서 현재 위치에서 이동한 위치를 반환
        if (hasRightConnection(position)) { //현재위치가 연결이면 오른쪽으로 이동
            return position.moveRight();
        }
        if (hasLeftConnection(position)) { //현재위치가 연결이 아니고 왼쪽칸이 연결이면 왼쪽으로 이동
            return position.moveLeft();
        }
        return position; //연결이 없으면 그대로 반환
    }

    private boolean hasLeftConnection(Position position) { //왼쪽칸이 연결인지 확인
        int leftIndex = position.value() - 1; //왼쪽칸의 index는 현재위치에서 -1
        if (leftIndex < 0) { //왼쪽칸이 없으면 false 반환
            return false;
        }
        return points.get(leftIndex).isConnected(); //왼쪽칸이 연결이면 true 반환
    }

    private boolean hasRightConnection(Position position) { //오른쪽칸이 연결인지 확인
        int rightIndex = position.value();//오른쪽칸의 index는 현재위치와 같음
        if (rightIndex >= points.size()) { //오른쪽칸이 없으면 false 반환
            return false;
        }
        return points.get(rightIndex).isConnected(); //오른쪽칸이 연결이면 true 반환
    }
}
