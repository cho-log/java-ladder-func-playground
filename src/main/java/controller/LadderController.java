package controller;

import domain.EndPositions;
import domain.Height;
import domain.Ladder;
import domain.Width;
import domain.random.ConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(ConnectionGenerator connectionGenerator) {
        Width width = new Width(inputView.getWidth());
        Height height = new Height(inputView.getHeight());
        Ladder ladder = Ladder.createLadder(width, height, connectionGenerator);

        outputView.printLadder(ladder);
        outputView.printEndPositions(ladder.findEndPositions(width));
    }
}
