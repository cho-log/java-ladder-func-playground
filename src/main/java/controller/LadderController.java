package controller;

import domain.BooleanGenerator;
import domain.Ladder;
import domain.LadderSize;
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
        LadderSize width = inputView.readWidth();
        LadderSize height = inputView.readHeight();
        Ladder ladder = Ladder.create(height, width, new RandomBooleanGenerator());
        outputView.printLadder(ladder);
    }
}
