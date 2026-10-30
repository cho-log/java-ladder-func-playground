package view;

import domain.Connection;
import domain.EndPositions;
import domain.Ladder;
import domain.Line;
import domain.Position;
import java.util.List;

public class OutputView {
    private String formatConnection(Connection connection){
        if (connection == Connection.CONNECTED) {
            return "-----";
        }
        return "     ";
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append("    |");
        for (Connection connection : line.getConnections()) {
            builder.append(formatConnection(connection)).append("|");
        }
        System.out.println(builder);
    }

    public void printLadder(Ladder ladder){
        System.out.println("실행결과");
        System.out.println();
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    public void printEndPositions(EndPositions endPositions){
        List<Position> positions = endPositions.getEndPositions();
        System.out.println();
        for (int i = 0; i < positions.size(); i++) {
            System.out.println(i + " -> " + positions.get(i).getPosition());
        }
    }
}
