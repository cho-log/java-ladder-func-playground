package domain;

public class LadderGame {
    private final Ladder ladder;
    private final GameResults results;

    public LadderGame(Participants participants, Outcomes outcomes, LadderHeight height, ConnectionGenerator generator) {
        outcomes.validateCount(participants.getWidth());
        this.ladder = new Ladder(participants.getWidth(), height, generator);
        this.results = new GameResults(participants, outcomes, ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GameResults getResults() {
        return results;
    }
}
