package controller;

import domain.Height;
import domain.Ladder;
import domain.Width;
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
        Width width = new Width(inputView.getWidth());
        Height height = new Height(inputView.getHeight());

        Ladder ladder = Ladder.createLadder(width, height, connectionGenerator);
        outputView.printLadder(ladder);
    }
}
