package controller;

import domain.BooleanGenerator;
import domain.Ladder;
import domain.LadderSize;
import domain.RandomBooleanGenerator;
import view.OutputView;

public class LadderController {

    private static final LadderSize LADDER_HEIGHT = new LadderSize(4);
    private static final LadderSize LADDER_WIDTH = new LadderSize(4);

    private final OutputView outputView;

    public LadderController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Ladder ladder = Ladder.create(LADDER_HEIGHT, LADDER_WIDTH, booleanGenerator);
        outputView.printLadder(ladder);
    }
}
