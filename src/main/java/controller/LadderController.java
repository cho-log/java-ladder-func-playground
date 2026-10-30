package controller;

import domain.GameResults;
import domain.Height;
import domain.Ladder;
import domain.LadderFactory;
import domain.LadderResults;
import domain.Outcomes;
import domain.Participants;
import domain.Width;
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
        validateGameSetup(participants, outcomes);

        Width width = new Width(participants.getSize());
        Height height = new Height(inputView.readHeight());

        Ladder ladder = ladderFactory.createLadder(width, height);
        LadderResults results = new LadderResults(width, ladder);

        GameResults gameResults = new GameResults(participants, outcomes, results);

        outputView.printLadder(ladder, gameResults, outcomes);
        outputView.printResult(results);
    }

    private void validateGameSetup(Participants participants, Outcomes outcomes) {
        if (participants.getSize() != outcomes.getSize()) {
            throw new IllegalArgumentException("참여자 수와 당첨 결과 수가 같아야 합니다.");
        }
    }
}
