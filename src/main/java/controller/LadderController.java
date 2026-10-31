package controller;

import domain.game.GameResults;
import domain.game.GameSetup;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.LadderResults;
import domain.outcome.Outcomes;
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
        Participants participants = readParticipants(parser);
        Outcomes outcomes = readOutcomes(parser);
        Width width = new GameSetup(participants, outcomes).getWidth();
        Ladder ladder = createLadder(width);
        GameResults gameResults = createGameResults(participants, outcomes, width, ladder);
        outputView.printGameResult(participants, ladder, outcomes);
        requestResults(participants, gameResults);
    }

    private Participants readParticipants(GameInputParser parser) {
        return new Participants(parser.parseParticipants(inputView.readParticipantNames()));
    }

    private Outcomes readOutcomes(GameInputParser parser) {
        return new Outcomes(parser.parseOutcomes(inputView.readOutcomeValues()));
    }

    private Ladder createLadder(Width width) {
        Height height = new Height(inputView.readHeight());
        return ladderFactory.createLadder(width, height);
    }

    private GameResults createGameResults(
            Participants participants,
            Outcomes outcomes,
            Width width,
            Ladder ladder
    ) {
        LadderResults ladderResults = new LadderResults(width, ladder);
        return new GameResults(participants, outcomes, ladderResults);
    }

    private void requestResults(Participants participants, GameResults gameResults) {
        ResultController resultController = new ResultController(inputView, outputView);
        resultController.run(participants, gameResults);
    }
}
