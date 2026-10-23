package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

public class OutputView {

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            System.out.println(formatLine(line));
        }
    }

    //stringBuilder는 문자열을 더할때 사용하는것 append로 뒤에 붙인다.
    //[연결, 안이어, 연결] 일때
    //공백 |-----|  공백   |-----|
    private String formatLine(Line line) {
        StringBuilder builder = new StringBuilder(LadderFormat.MARGIN.symbol());
        builder.append(LadderFormat.VERTICAL.symbol());
        for (Point point : line.points()) {
            builder.append(formatPoint(point)); //연결되어있으면 -----를 반환, 연결되어있지 않으면 공백 5칸을 반환
            builder.append(LadderFormat.VERTICAL.symbol()); //연결되어있든 안되어있든 |를 붙인다.
        }
        return builder.toString(); //완성된 문자열을 반환
    }

    private String formatPoint(Point point) {
        if (point.isConnected()) {
            return LadderFormat.CONNECTED.symbol(); //연결되어있으면 -----를 반환
        }
        return LadderFormat.EMPTY.symbol(); //연결되어있지 않으면 공백 5칸을 반환
    }

}
