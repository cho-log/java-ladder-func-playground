package view;

import java.util.List;
import java.util.Map;
import model.Ladder;
import model.Line;
import model.Name;
import model.Names;
import model.Prize;
import model.Prizes;

public class OutputView {
    private static final String VERTICAL = "|";
    private static final String INDENT = "     ";
    private static final String CELL_FORMAT = "%5s ";
    private static final String RESULT_DELIMITER = " : ";

    public static void printLadder(Ladder ladder, Names names, Prizes prizes) {
        System.out.println("사다리 결과");

        for (Name name : names) {
            System.out.printf(CELL_FORMAT, name.getName());
        }
        System.out.println();
        for (Line line : ladder) {
            printLine(line.getLine());
        }
        for (Prize prize : prizes) {
            System.out.printf(CELL_FORMAT, prize.getPrize());
        }
        System.out.println();
    }

    private static void printLine(List<Boolean> points) {
        System.out.print(INDENT + VERTICAL);
        for (boolean point : points) {
            System.out.print(PointShape.from(point) + VERTICAL);
        }
        System.out.println();
    }

    public static void printSingleResult(Prize result) {
        System.out.println("실행 결과");
        System.out.println(result.getPrize());
    }

    public static void printAllResults(Map<Name, Prize> results) {
        System.out.println("실행 결과");
        for (Map.Entry<Name, Prize> entry : results.entrySet()) {
            System.out.println(entry.getKey().getName() + RESULT_DELIMITER + entry.getValue().getPrize());
        }
    }
}
