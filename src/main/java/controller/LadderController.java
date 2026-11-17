package controller;

import domain.Ladder;
import domain.Participant;
import domain.Participants;
import domain.Size;
import java.util.List;
import service.LadderService;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LadderService ladderService = new LadderService();

    public Ladder createLadder() {
        int width = inputView.getLadderWidth();
        int height = inputView.getLadderHeight();
        return ladderService.createLadder(height, width);
    }

    public Participants createParticipants(int width) {
        return ladderService.createParticipants(width);
    }

    public void getResult(Ladder ladder, Participants participants) {
        ladderService.getResult(ladder, participants);
    }

    public void printResult(Ladder ladder, Participants participants){
        outputView.printResultText();
        outputView.printLadder(ladder);
        outputView.printResult(participants);
    }
}
