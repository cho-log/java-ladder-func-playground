package view;

import domain.Connection;
import domain.Ladder;
import domain.Line;

public class ResultView {
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";

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
}
