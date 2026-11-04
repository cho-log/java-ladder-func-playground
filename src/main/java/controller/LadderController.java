package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderSize;
import domain.Names;
import domain.PlayerPrizes;
import domain.Prizes;
import domain.RandomBooleanGenerator;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderController {

    //private static final LadderSize LADDER_HEIGHT = new LadderSize(4);
    //private static final LadderSize LADDER_WIDTH = new LadderSize(4);
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Names names = retry(inputView::readNames);
        Prizes prizes = retry(inputView::readPrizes);
        LadderSize height = retry(inputView::readHeight);
        Ladder ladder = Ladder.create(height, new LadderSize(names.size()), new RandomBooleanGenerator());
        PlayerPrizes playerPrizes = PlayerPrizes.of(names, prizes, new LadderGame(ladder).play()); //개수검증을 먼저하도록 함 출력전에
        outputView.printLadderResult(names, ladder, prizes);
        showResults(playerPrizes);
    }

    private <T> T retry(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return retry(reader);
        }
    }
    private void showResults(PlayerPrizes playerPrizes) {
        String target = inputView.readTarget();
        while (!target.equals("all")) { //all이 입력되기 전 까지는 계속해서 결과를 보여준다.
            showPlayerPrize(playerPrizes, target);
            target = inputView.readTarget();
        }
        outputView.printAllPlayerPrizes(playerPrizes);//all이 입력되면 모든 결과를 보여준다.
    }

    private void showPlayerPrize(PlayerPrizes playerPrizes, String target) {
        try { //target에 해당하는 결과를 보여준다.
            outputView.printPlayerPrize(playerPrizes.find(target)); //target에 해당하는 결과를 찾아서 보여준다.
        } catch (IllegalArgumentException exception) { //target에 해당하는 결과가 없으면 에러메세지를 보여준다.
            outputView.printError(exception.getMessage()); //IllegalArgumentException이 발생하면 에러메세지를 보여준다.
        }
    }
}

