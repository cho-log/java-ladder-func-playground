package view;

import domain.game.GameResult;
import domain.game.GameResults;
import domain.ladder.Connection;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.outcome.Outcomes;
import domain.ladder.Position;
import domain.participant.Participants;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int COLUMN_WIDTH = 6;
    private static final String LABEL_INDENT = "   ";
    private static final String LADDER_INDENT = "     ";

    public void printGameResult(
            Participants participants,
            Ladder ladder,
            Outcomes outcomes
    ) {
        System.out.println("\n사다리 결과\n");
        printParticipants(participants);
        printLadder(ladder);
        printOutcomes(outcomes);
    }

    private void printParticipants(Participants participants) {
        StringBuilder line = new StringBuilder(LABEL_INDENT);

        for (int index = 0; index < participants.getSize(); index++) {
            Position position = new Position(index);
            String name = participants.getParticipantByPosition(position).getName();
            appendCentered(line, name);
        }

        System.out.println(line);
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(LADDER_INDENT + formatLine(line));
        }
    }

    private void printOutcomes(Outcomes outcomes) {
        StringBuilder line = new StringBuilder(LABEL_INDENT);

        for (int index = 0; index < outcomes.getSize(); index++) {
            Position position = new Position(index);
            String value = outcomes.getOutcomeByPosition(position).getOutcome();
            appendCentered(line, value);
        }

        System.out.println(line);
    }

    private String formatLine(Line line) {
        return line.getPoints().stream()
                   .map(connection -> "|" + formatConnection(connection))
                   .collect(Collectors.joining("", "", "|"));
    }

    private String formatConnection(Connection connection) {
        if (connection.isConnected()) {
            return "-----";
        }
        return "     ";
    }

    private void appendCentered(StringBuilder line, String value) {
        int remaining = Math.max(0, COLUMN_WIDTH - getDisplayWidth(value));
        int leftPadding = remaining / 2;
        int rightPadding = remaining - leftPadding;

        line.append(" ".repeat(leftPadding));
        line.append(value);
        line.append(" ".repeat(rightPadding));
    }

    private int getDisplayWidth(String value) {
        return IntStream.range(0, value.length())
                        .map(index -> getCharacterWidth(value.charAt(index)))
                        .sum();
    }

    private int getCharacterWidth(char character) {
        if (character >= '가' && character <= '힣') {
            return 2;
        }

        return 1;
    }

    public void printError(String error) {
        System.out.println(error);
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
