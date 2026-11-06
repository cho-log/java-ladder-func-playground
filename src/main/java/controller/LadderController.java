package controller;

import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderResult;
import model.Name;
import model.Names;
import model.Prizes;
import model.generator.PointGenerator;
import model.generator.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    public void run() {
        Names names = new Names(InputView.inputNames());
        Prizes prizes = new Prizes(InputView.inputResults(), names.getParticipantCount());
        Ladder ladder = new Ladder(names.getParticipantCount(), new Height(InputView.inputHeight()), pointGenerator());
        OutputView.printLadder(ladder, names, prizes);

        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        printResult(ladderGame.getLadderResult());
    }

    private void printResult(LadderResult ladderResult) {
        String name = InputView.inputName();

        if (Name.ALL.equals(name)) {
            OutputView.printAllResults(ladderResult.findAllResults());
            return;
        }
        OutputView.printSingleResult(ladderResult.findResultOf(name));
    }

    private PointGenerator pointGenerator() {
        return new RandomPointGenerator();
    }
}
