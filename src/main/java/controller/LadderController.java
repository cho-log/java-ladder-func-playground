package controller;

import domain.Ladder;
import domain.random.ConnectionGenerator;
import view.OutputView;

public class LadderController {
    // InputVIew 추가
    private final OutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderController(OutputView outputView, ConnectionGenerator connectionGenerator) {
        this.outputView = outputView;
        this.connectionGenerator = connectionGenerator;
    }

    public void run() {
        Ladder ladder = Ladder.createLadder(4, 4, connectionGenerator);
        outputView.printLadder(ladder);
    }
}
