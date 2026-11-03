package domain;

import domain.connection.ConnectionGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.participant.Participants;
import domain.result.GameResults;
import domain.result.Outcomes;

public class LadderGame {
    private final Ladder ladder;
    private final GameResults results;

    public LadderGame(Participants participants, Outcomes outcomes, LadderHeight height, ConnectionGenerator generator) {
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
