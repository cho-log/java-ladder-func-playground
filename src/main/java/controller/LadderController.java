package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderSize;
import domain.Names;
import domain.PlayerPrizes;
import domain.Prizes;
import domain.RandomBooleanGenerator;
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
        Names names = inputView.readNames();
        Prizes prizes = inputView.readPrizes();
        LadderSize height = inputView.readHeight();
        Ladder ladder = Ladder.create(height, new LadderSize(names.size()), new RandomBooleanGenerator());
        outputView.printLadderResult(names, ladder, prizes);
        showResults(PlayerPrizes.of(names, prizes, new LadderGame(ladder).play()));
    }

    private void showResults(PlayerPrizes playerPrizes) {
        String target = inputView.readTarget();
        while (!target.equals("all")) { //all이 입력되기 전 까지는 계속해서 결과를 보여준다.
            outputView.printPlayerPrize(playerPrizes.find(target));
            target = inputView.readTarget();
        }
        outputView.printAllPlayerPrizes(playerPrizes);//all이 입력되면 모든 결과를 보여준다.
    }
}

