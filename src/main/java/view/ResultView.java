package view;

import domain.Connection;
import domain.GameResults;
import domain.Ladder;
import domain.LadderPath;
import domain.Line;
import domain.Outcome;
import domain.Outcomes;
import domain.ParticipantName;
import domain.Participants;
import domain.ResultQuery;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int MIN_COLUMN_WIDTH = 6;
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";

    public static void printGame(Participants participants, Ladder ladder, Outcomes outcomes) {
        System.out.println("\n사다리 결과");
        int columnWidth = calculateColumnWidth(outcomes);
        printNames(participants, columnWidth);
        printLadder(ladder, columnWidth);
        printOutcomes(outcomes, columnWidth);
    }

    private static int calculateColumnWidth(Outcomes outcomes) {
        int columnWidth = MIN_COLUMN_WIDTH;
        for (Outcome outcome : outcomes.getValues()) {
            columnWidth = Math.max(columnWidth, outcome.getValue().length() + 1);
        }
        return columnWidth;
    }

    private static void printNames(Participants participants, int columnWidth) {
        for (ParticipantName name : participants.getNames()) {
            System.out.printf("%-" + columnWidth + "s", name.getValue());
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder, int columnWidth) {
        for (Line line : ladder.getLines()) {
            printLine(line, columnWidth);
        }
    }

    private static void printLine(Line line, int columnWidth) {
        StringBuilder result = new StringBuilder(VERTICAL_LINE);
        for (Connection connection : line.getConnections()) {
            result.append(toSymbol(connection, columnWidth - 1)).append(VERTICAL_LINE);
        }
        System.out.println(result);
    }

    private static String toSymbol(Connection connection, int width) {
        if (connection == Connection.CONNECTED) {
            return "-".repeat(width);
        }
        return " ".repeat(width);
    }

    private static void printOutcomes(Outcomes outcomes, int columnWidth) {
        for (Outcome outcome : outcomes.getValues()) {
            System.out.printf("%-" + columnWidth + "s", outcome.getValue());
        }
        System.out.println();
    }

    public static void printResults(ResultQuery query, GameResults results) {
        System.out.println("\n실행 결과");
        if (query.isAll()) {
            printAll(results);
            return;
        }
        System.out.println(results.getResult(query.getName()).getValue());
    }

    private static void printAll(GameResults results) {
        for (Map.Entry<ParticipantName, Outcome> result : results.getResults().entrySet()) {
            System.out.println(result.getKey().getValue() + " : " + result.getValue().getValue());
        }
    }

    public static void print(Ladder ladder) {
        System.out.println("실행결과\n");
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder result = new StringBuilder(VERTICAL_LINE);
        for (Connection connection : line.getConnections()) {
            result.append(toSymbol(connection)).append(VERTICAL_LINE);
        }
        System.out.println(result);
    }

    private static String toSymbol(Connection connection) {
        if (connection == Connection.CONNECTED) {
            return CONNECTED_LINE;
        }
        return DISCONNECTED_LINE;
    }

    public static void printPaths(List<LadderPath> paths) {
        System.out.println();
        for (LadderPath path : paths) {
            System.out.println(path.getStart().getValue() + " -> " + path.getEnd().getValue());
        }
    }
}
