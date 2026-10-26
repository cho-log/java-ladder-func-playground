public class Application {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(4, 4);
        LadderOutputView ladderOutputView = new LadderOutputView();
        ladderOutputView.print(ladder);
    }
}
