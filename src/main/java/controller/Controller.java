package controller;

import domain.ColumnCount;
import domain.GameResult;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Results;
import domain.RowCount;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {
        Names names = new Names(inputNameList(InputView.inputNames()));
        Results results = new Results(inputResultList(InputView.inputResults()), names);
        Ladder ladder = createLadder(names.size());
        GameResult gameResult = createGameResult(ladder, names, results);
        OutputView.printLadder(ladder, names.getNames(), results.getResults());
        printSelectedResult(gameResult);
    }

    private Ladder createLadder(int nameCount) {
        ColumnCount column = new ColumnCount(nameCount);
        RowCount row = new RowCount(InputView.inputRow());
        return new LadderGenerator().generate(row, column);
    }

    private GameResult createGameResult(Ladder ladder, Names names, Results results) {
        LadderGame ladderGame = new LadderGame(ladder);
        List<Integer> positions = ladderGame.getResult();
        return new GameResult(names, positions, results);
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
        List<Name> nameList = new ArrayList<>();
        for (String name : value.split(",", -1)) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    private List<Result> inputResultList(String value) {
        List<Result> resultList = new ArrayList<>();
        for (String result : value.split(",", -1)) {
            resultList.add(new Result(result.trim()));
        }
        return resultList;
    }
}
