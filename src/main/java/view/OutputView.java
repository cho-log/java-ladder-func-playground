package view;

import java.util.List;
import model.Ladder;
import model.Line;

public class OutputView {
    private static final String VERTICAL = "|";

    public static void printLadder(Ladder ladder){
        System.out.println("실행결과");
        for (Line line : ladder.getLines()) {
            printLine(line.getLine());
        }
    }
    private static void printLine(List<Boolean> points){
        System.out.print(VERTICAL);
        for (boolean point : points) {
            System.out.print(PointShape.from(point) + VERTICAL);
        }
        System.out.println();
    }

    public static void printResult(List<Integer> result){
        for(int i=0;i<result.size();i++){
            System.out.println(i+" -> "+result.get(i));
        }

    }
}
