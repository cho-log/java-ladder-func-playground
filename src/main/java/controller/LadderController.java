package controller;

import domain.Height;
import domain.Ladder;
import domain.game.GameResult;
import domain.game.Name;
import domain.game.Names;
import domain.game.Prizes;
import domain.random.ConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(ConnectionGenerator connectionGenerator) {
        Names names = Names.createNames(inputView.readNames());
        Prizes prizes = Prizes.createPrizes(inputView.readPrizes());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.createLadder(names.toWidth(), height, connectionGenerator);
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        outputView.printLadder(ladder, names, prizes);
        showResults(gameResult);
    }

    private void showResults(GameResult gameResult) {
        String targetName = inputView.readTargetName();
        while (!targetName.equals(ALL)) {
            outputView.printOneResult(gameResult.findPrize(new Name(targetName)));
            targetName = inputView.readTargetName();
        }
        outputView.printAllResults(gameResult);
    }
}
