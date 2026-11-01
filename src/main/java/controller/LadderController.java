package controller;

import domain.EndPositions;
import domain.Height;
import domain.Ladder;
import domain.Position;
import domain.Width;
import domain.game.Name;
import domain.game.Names;
import domain.game.Prize;
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
        Width width = names.toWidth();
        Prizes prizes = Prizes.createPrizes(inputView.readPrizes(), width);
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.createLadder(width, height, connectionGenerator);

        outputView.printLadder(ladder, names, prizes);
        showResults(names, ladder.findEndPositions(), prizes);
    }

    private void showResults(Names names, EndPositions endPositions, Prizes prizes) {
        String targetName = inputView.readTargetName();
        while (!targetName.equals(ALL)) {
            outputView.printOneResult(findPrize(new Name(targetName), names, endPositions, prizes));
            targetName = inputView.readTargetName();
        }
        printAllResults(names, endPositions, prizes);
    }

    private void printAllResults(Names names, EndPositions endPositions, Prizes prizes) {
        outputView.printResultTitle();
        for (Name name : names.getNames()) {
            outputView.printNameAndPrize(name, findPrize(name, names, endPositions, prizes));
        }
    }

    private Prize findPrize(Name name, Names names, EndPositions endPositions, Prizes prizes) {
        Position startPosition = names.findPosition(name);
        Position endPosition = endPositions.findEndPosition(startPosition);
        return prizes.findPrize(endPosition);
    }
}
