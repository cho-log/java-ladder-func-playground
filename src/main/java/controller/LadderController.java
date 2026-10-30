package controller;

import domain.Ladder;
import domain.random.ConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderController(InputView inputView, OutputView outputView, ConnectionGenerator connectionGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.connectionGenerator = connectionGenerator;
    }

    public void run() {
        Ladder ladder = Ladder.createLadder(4, 4, connectionGenerator);
        outputView.printLadder(ladder);
    }
}
