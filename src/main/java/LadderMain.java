import model.Ladder;
import model.LadderResult;
import view.InputView;
import view.OutputView;
import model.Names;
import model.Prizes;

public class LadderMain {
    public static void main(String[] args) {
        Names names =new Names(InputView.inputNames());
        Prizes prizes =new Prizes(InputView.inputResults(),names.getSize());
        Ladder ladder=new Ladder(names.getSize(),InputView.inputHeight());
        OutputView.printLadder(ladder,names, prizes);

        LadderResult ladderResult= new LadderResult(names,prizes,ladder);

        String name = InputView.inputName();

        if (name.equals("all")) {
            OutputView.printAllResults(ladderResult.findAllResults());
            return;
        }
        OutputView.printSingleResult(ladderResult.findResultOf(name));
    }
}
