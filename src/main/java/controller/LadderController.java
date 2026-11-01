package controller;

import model.Ladder;
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
        Prizes prizes = new Prizes(InputView.inputResults(), names.getSize());
        Ladder ladder = new Ladder(names.getSize(), InputView.inputHeight(), pointGenerator());
        OutputView.printLadder(ladder, names, prizes);

        LadderResult ladderResult = new LadderResult(names, prizes, ladder);
        printResult(ladderResult);
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
