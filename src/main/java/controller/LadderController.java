package controller;

import domain.game.GameResult;
import domain.game.GameResults;
import domain.game.GameSetup;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.LadderResults;
import domain.outcome.Outcomes;
import domain.participant.Participant;
import domain.participant.Participants;
import domain.ladder.Width;
import parser.GameInputParser;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderFactory ladderFactory;

    public LadderController(InputView inputView, OutputView outputView, LadderFactory ladderFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderFactory = ladderFactory;
    }

    public void run() {
        try {
            runApp();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    public void runApp() {
        GameInputParser parser = new GameInputParser();
        Participants participants = new Participants(parser.parseParticipants(inputView.readParticipantNames()));
        Outcomes outcomes = new Outcomes(parser.parseOutcomes(inputView.readOutcomeValues()));

        GameSetup gameSetup = new GameSetup(participants, outcomes);

        Width width = gameSetup.getWidth();
        Height height = new Height(inputView.readHeight());

        Ladder ladder = ladderFactory.createLadder(width, height);
        LadderResults results = new LadderResults(width, ladder);

        GameResults gameResults = new GameResults(participants, outcomes, results);

        outputView.printGameResult(participants, ladder, outcomes);

        ResultController resultController = new ResultController(inputView, outputView);
        resultController.run(participants, gameResults);
    }
}
