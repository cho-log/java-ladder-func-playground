package view;

import domain.Connection;
import domain.GameResult;
import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Result;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLadder(Ladder ladder, List<Name> names, List<Result> results) {
        System.out.println("사다리 결과\n");
        printNames(names);
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        printResults(results);
    }

    private static void printNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.getValue());
        }
        System.out.println();
    }

    private static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.printf("%6s", result.getValue());
        }
        System.out.println();
    }

    private static void printLine(Line line) {
        System.out.print("    |");
        for (Connection point : line.getPoints()) {
            printPoint(point);
        }
        System.out.println();
    }

    private static void printPoint(Connection point) {
        if (point.isConnected()) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printResult(GameResult gameResult, Name name) {
        System.out.println("실행 결과");
        System.out.println(gameResult.findResult(name).getValue());
    }

    public static void printAllResult(GameResult gameResult) {
        System.out.println("실행 결과");
        for (Map.Entry<Name, Result> entry : gameResult.getResultEntries()) {
            printResultEntry(entry);
        }
    }

    private static void printResultEntry(Map.Entry<Name, Result> entry) {
        System.out.println(entry.getKey().getValue() + " : " + entry.getValue().getValue());
    }

}
