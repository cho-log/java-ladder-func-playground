import controller.LadderController;
import model.Ladder;
import model.LadderResult;
import view.InputView;
import view.OutputView;
import model.Names;
import model.Prizes;

public class LadderMain {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.run();
    }
}
