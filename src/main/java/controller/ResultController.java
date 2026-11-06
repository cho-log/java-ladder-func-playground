package controller;

import domain.game.GameResult;
import domain.game.GameResults;
import domain.participant.Participant;
import domain.participant.Participants;
import view.InputView;
import view.OutputView;

public class ResultController {
    private final InputView inputView;
    private final OutputView outputView;

    public ResultController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(Participants participants, GameResults gameResults) {
        String target = inputView.readResultTarget();

        while (!"all".equals(target)) {
            printPersonalGameResult(participants, gameResults, target);
            target = inputView.readResultTarget();
        }

        outputView.printAllGameResults(gameResults);

    }

    private void printPersonalGameResult(
            Participants participants,
            GameResults gameResults,
            String target
    ) {
        Participant participant = participants.getParticipant(target);
        GameResult gameResult = gameResults.getGameResult(participant);
        outputView.printPersonalGameResult(gameResult);
    }
}
