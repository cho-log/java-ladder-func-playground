package controller;

import model.Ladder;
import model.LadderResult;
import model.Names;
import model.Prizes;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String ALL = "all";

    public void run() {
        Names names = new Names(InputView.inputNames());
        Prizes prizes = new Prizes(InputView.inputResults(), names.getSize());
        Ladder ladder = new Ladder(names.getSize(), InputView.inputHeight());
        OutputView.printLadder(ladder, names, prizes);

        LadderResult ladderResult = new LadderResult(names, prizes, ladder);
        printResult(ladderResult);
    }

    private void printResult(LadderResult ladderResult) {
        String name = InputView.inputName();

        if (name.equals(ALL)) {
            OutputView.printAllResults(ladderResult.findAllResults());
            return;
        }
        OutputView.printSingleResult(ladderResult.findResultOf(name));
    }

}
