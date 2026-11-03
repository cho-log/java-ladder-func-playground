package controller;

import domain.Height;
import domain.Ladder;
import domain.game.GameResult;
import domain.game.Name;
import domain.game.Names;
import domain.game.Prizes;
import domain.random.ConnectionGenerator;
import exception.ErrorMessage;
import java.util.List;
import java.util.function.Supplier;
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
        Names names = retry(this::readNames);
        Prizes prizes = retry(() -> readPrizes(names));
        Height height = retry(() -> new Height(inputView.readHeight()));
        Ladder ladder = Ladder.createLadder(names.toWidth(), height, connectionGenerator);
        GameResult gameResult = GameResult.of(names, ladder, prizes);

        outputView.printLadder(ladder, names, prizes);
        showResults(gameResult);
    }

    private Names readNames() {
        List<String> inputNames = inputView.readNames();
        validateNotCommand(inputNames);
        return Names.createNames(inputNames);
    }

    private void validateNotCommand(List<String> inputNames) {
        if (inputNames.contains(ALL)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_RESERVED.getMessage());
        }
    }

    private Prizes readPrizes(Names names) {
        Prizes prizes = Prizes.createPrizes(inputView.readPrizes());
        GameResult.validateSameCount(names, prizes);
        return prizes;
    }

    private void showResults(GameResult gameResult) {
        String targetName = inputView.readTargetName();
        while (!targetName.equals(ALL)) {
            showOneResult(gameResult, targetName);
            targetName = inputView.readTargetName();
        }
        outputView.printAllResults(gameResult);
    }

    private void showOneResult(GameResult gameResult, String targetName) {
        try {
            outputView.printOneResult(gameResult.findPrize(new Name(targetName)));
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
        }
    }

    private <T> T retry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return retry(supplier);
        }
    }
}
