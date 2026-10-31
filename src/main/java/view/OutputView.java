package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.PlayerPrize;
import domain.PlayerPrizes;
import domain.Point;
import domain.Prize;
import domain.Prizes;

public class OutputView {

    public void printLadderResult(Names names, Ladder ladder, Prizes prizes) {
        System.out.println(MessageFormat.RESULT_LADDER.message());
        System.out.println();
        System.out.println(formatNames(names));
        printLadder(ladder);
        System.out.println(formatPrizes(prizes));
        System.out.println();
    }

    public void printPlayerPrize(PlayerPrize playerPrize) {
        System.out.println(MessageFormat.RESULT_TITLE.message());
        System.out.println(playerPrize.prize().value());
        System.out.println();
    }

    public void printAllPlayerPrizes(PlayerPrizes playerPrizes) {
        System.out.println(MessageFormat.RESULT_TITLE.message());
        for (PlayerPrize playerPrize : playerPrizes.all()) {
            System.out.println(formatPlayerPrize(playerPrize));
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            System.out.println(formatLine(line));
        }
    }

    private String formatNames(Names names) {
        StringBuilder builder = new StringBuilder(LadderFormat.MARGIN.symbol());
        for (Name name : names.names()) {
            builder.append(String.format(LadderFormat.CELL.symbol(), name.value()));
        }
        return builder.toString();
    }

    private String formatPrizes(Prizes prizes) {
        StringBuilder builder = new StringBuilder(LadderFormat.MARGIN.symbol());
        for (Prize prize : prizes.prizes()) {
            builder.append(String.format(LadderFormat.CELL.symbol(), prize.value()));
        }
        return builder.toString();
    }

    private String formatPlayerPrize(PlayerPrize playerPrize) {
        return playerPrize.name().value()
                + MessageFormat.RESULT_SEPARATOR.message()
                + playerPrize.prize().value();
    }


    //stringBuilder는 문자열을 더할때 사용하는것 append로 뒤에 붙인다.
    //[연결, 안이어, 연결] 일때
    //공백 |-----|  공백   |-----|
    private String formatLine(Line line) {
        StringBuilder builder = new StringBuilder(LadderFormat.MARGIN.symbol());
        builder.append(LadderFormat.VERTICAL.symbol());
        for (Point point : line.points()) {
            builder.append(formatPoint(point)); //연결되어있으면 -----를 반환, 연결되어있지 않으면 공백 5칸을 반환
            builder.append(LadderFormat.VERTICAL.symbol()); //연결되어있든 안되어있든 |를 붙인다.
        }
        return builder.toString(); //완성된 문자열을 반환
    }

    private String formatPoint(Point point) {
        if (point.isConnected()) {
            return LadderFormat.CONNECTED.symbol(); //연결되어있으면 -----를 반환
        }
        return LadderFormat.EMPTY.symbol(); //연결되어있지 않으면 공백 5칸을 반환
    }


}
