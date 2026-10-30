package view;

import domain.GameResult;
import domain.GameResults;
import domain.Ladder;
import domain.LadderResults;
import domain.Line;
import domain.Outcomes;
import domain.Position;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printLadder(Ladder ladder, GameResults results, Outcomes outcomes) {
        System.out.println("\n사다리 결과\n");

        printParticipants(results);
        for (Line line : ladder.getLines()) {
            System.out.println("     " + formatLine(line));
        }
        printOutcomes(outcomes);
    }

    private void printParticipants(GameResults results) {
        for (GameResult gameResult : results.getGameResults()) {
            System.out.print(gameResult.getParticipant().getName() + "  ");
        }
        System.out.println();
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

    private void printOutcomes(Outcomes outcomes) {
        for (int index = 0; index < outcomes.getSize(); index++) {
            Position position = new Position(index);
            System.out.print(outcomes.getOutcomeByPosition(position).getOutcome() + "  ");
        }
        System.out.println();
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

    public void printPersonalGameResult(GameResult gameResult) {
        System.out.println("\n실행 결과");
        System.out.println(gameResult.getOutcome().getOutcome());
    }

    public void printAllGameResults(GameResults gameResults) {
        System.out.println("\n실행 결과");

        for (GameResult gameResult : gameResults.getGameResults()) {
            System.out.println(formatGameResult(gameResult));
        }
    }

    private String formatGameResult(GameResult gameResult) {
        return gameResult.getParticipant().getName() + " : " + gameResult.getOutcome().getOutcome();
    }
}
