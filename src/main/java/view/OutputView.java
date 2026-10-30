package view;

import domain.Ladder;
import domain.LadderResults;
import domain.Line;
import domain.Position;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printLadder(Ladder ladder) {
        System.out.println("\n실행결과\n");

        for (Line line : ladder.getLines()) {
            System.out.println("     " + formatLine(line));
        }
    }

    private String formatLine(Line line) {
        List<String> result = new ArrayList<>();

        for (Boolean point : line.getPoints()) {
            result.add("|");

            if (point) {
                result.add("-----");
                continue;
            }

            result.add("     ");
        }

        result.add("|");

        return String.join("", result);
    }

    public void printError(String error) {
        System.out.println(error);
    }

    public void printResult(LadderResults results) {
        System.out.println();

        for (int i = 0; i < results.size(); i++) {
            Position start = new Position(i);
            Position destination = results.getDestination(start);

            System.out.println(start.getValue() + " -> " + destination.getValue());
        }
    }
}
