import domain.Ladder;
import domain.RandomConnectionGenerator;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(new RandomConnectionGenerator());
        ResultView.print(ladder);
    }
}
