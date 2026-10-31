package view;

import domain.Connection;
import domain.Ladder;
import domain.Line;
import domain.game.Name;
import domain.game.Names;
import domain.game.Prize;
import domain.game.Prizes;

public class OutputView {
    private static final String CELL_FORMAT = "%6s";

    private String formatConnection(Connection connection){
        if (connection.isConnected()) {
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

    private void printNames(Names names) {
        StringBuilder builder = new StringBuilder();
        for(Name name : names.getNames()) {
            builder.append(String.format(CELL_FORMAT, name.getName()));
        }
        System.out.println(builder);
    }

    private void printPrizes(Prizes prizes) {
        StringBuilder builder = new StringBuilder();
        for(Prize prize : prizes.getPrizes()) {
            builder.append(String.format(CELL_FORMAT, prize.getPrize()));
        }
        System.out.println(builder);
    }

    public void printLadder(Ladder ladder, Names names, Prizes prizes) {
        System.out.println("사다리 결과");
        System.out.println();

        printNames(names);
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        printPrizes(prizes);
        System.out.println();
    }

    public void printOneResult(Prize prize) {
        printResultTitle();
        System.out.println(prize.getPrize());
    }

    public void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printNameAndPrize(Name name, Prize prize) {
        System.out.println(name.getName() + " : " + prize.getPrize());
    }
}
