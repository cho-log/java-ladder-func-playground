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
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {
        Names names = new Names(inputNameList(InputView.inputNames()));
        Results results = new Results(inputResultList(InputView.inputResults()));
        NameResultPairs nameResultPairs = new NameResultPairs(names, results);
        Ladder ladder = createLadder(nameResultPairs.size());
        GameResult gameResult = createGameResult(ladder, nameResultPairs);
        OutputView.printLadder(ladder, nameResultPairs);
        printSelectedResult(gameResult);
    }

    private Ladder createLadder(int nameCount) {
        ColumnCount column = new ColumnCount(nameCount);
        RowCount row = new RowCount(InputView.inputRow());
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
            String input = InputView.inputResultName();
            finished = processResultRequest(gameResult, input);
        }
    }

    private boolean processResultRequest(GameResult gameResult, String input) {
        if (input.equals("all")) {
            OutputView.printAllResult(gameResult);
            return true;
        }
        OutputView.printResult(gameResult, new Name(input));
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
}
