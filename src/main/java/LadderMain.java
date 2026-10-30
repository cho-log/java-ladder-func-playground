import model.Ladder;
import model.LadderResult;
import view.InputView;
import view.OutputView;

public class LadderMain {
    public static void main(String[] args) {

        Ladder ladder=new Ladder(InputView.inputWidth(),InputView.inputHeight());
        OutputView.printLadder(ladder);

        LadderResult ladderResult= new LadderResult(ladder);
        OutputView.printResult(ladderResult.getResults());
    }
}
