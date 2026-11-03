package controller;

import domain.ColumnCount;
import domain.GameResult;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Name;
import domain.NameResultPairs;
import domain.Names;
import domain.Result;
import domain.Results;
import domain.RowCount;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {
        Names names = retry(this::readNames);
        NameResultPairs nameResultPairs = retry(() -> readNameResultPairs(names));
        Ladder ladder = createLadder(nameResultPairs.size());
        GameResult gameResult = createGameResult(ladder, nameResultPairs);
        OutputView.printLadder(ladder, nameResultPairs);
        printSelectedResult(gameResult);
    }

    private Names readNames() {
        String input = InputView.inputNames();
        return new Names(inputNameList(input));
    }

    private NameResultPairs readNameResultPairs(Names names) {
        String input = InputView.inputResults();
        Results results = new Results(inputResultList(input));
        return new NameResultPairs(names, results);
    }

    private Ladder createLadder(int nameCount) {
        ColumnCount column = new ColumnCount(nameCount);
        RowCount row = retry(() -> new RowCount(InputView.inputRow()));
        return new LadderGenerator().generate(row, column);
    }

    private GameResult createGameResult(Ladder ladder, NameResultPairs nameResultPairs) {
        LadderGame ladderGame = new LadderGame(ladder);
        List<Integer> positions = ladderGame.getResult();
        return new GameResult(nameResultPairs, positions);
    }

    private void printSelectedResult(GameResult gameResult) {
        boolean finished = false;
        while (!finished) {
            finished = retry(() -> processResultRequest(gameResult));
        }
    }

    private boolean processResultRequest(GameResult gameResult) {
        String input = InputView.inputResultName();
        if (input.equals("all")) {
            OutputView.printAllResult(gameResult);
            return true;
        }
        OutputView.printResult(gameResult.findResult(new Name(input)).getValue());
        return false;
    }

    private List<Name> inputNameList(String value) {
        return Arrays.stream(value.split(",", -1))
                .map(String::trim)
                .map(Name::new)
                .toList();
    }

    private List<Result> inputResultList(String value) {
        return Arrays.stream(value.split(",", -1))
                .map(String::trim)
                .map(Result::new)
                .toList();
    }

    private <T> T retry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return retry(supplier);
        }
    }
}
