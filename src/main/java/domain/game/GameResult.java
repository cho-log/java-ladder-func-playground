package domain.game;

import domain.outcome.Outcome;
import domain.participant.Participant;

public class GameResult {
    private final Participant participant;
    private final Outcome outcome;

    public GameResult(Participant participant, Outcome outcome) {
        this.participant = participant;
        this.outcome = outcome;
    }

    public boolean hasParticipant(Participant participant) {
        return this.participant.getName().equals(participant.getName());
    }

    public Participant getParticipant() {
        return participant;
    }

    public Outcome getOutcome() {
        return  outcome;
    }
}
