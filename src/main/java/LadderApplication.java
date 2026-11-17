import controller.LadderController;
import domain.Ladder;
import domain.Participants;

public class LadderApplication {
    public static void main(String[] args) {
        final LadderController ladderController = new LadderController();
        Ladder ladder = ladderController.createLadder();
        Participants participants = ladderController.createParticipants(ladder.getWidth());
        ladderController.getResult(ladder, participants);
        ladderController.printResult(ladder, participants);
    }
}
