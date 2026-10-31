package view;

import java.util.List;
import java.util.Map;
import model.Ladder;
import model.Line;
import model.Names;
import model.Prizes;

public class OutputView {
    private static final String VERTICAL = "|";

    public static void printLadder(Ladder ladder, Names names, Prizes prizes) {
        System.out.println("사다리 결과");

        for (String name : names.getNames()) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
        for (Line line : ladder.getLines()) {
            printLine(line.getLine());
        }
        for (String result : prizes.getPrizes()) {
            System.out.printf("%5s ", result);
        }
        System.out.println();
    }

    private static void printLine(List<Boolean> points) {
        System.out.print("     " + VERTICAL);
        for (boolean point : points) {
            System.out.print(PointShape.from(point) + VERTICAL);
        }
        System.out.println();
    }

    public static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printAllResults(Map<String, String> results) {
        System.out.println("실행 결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
