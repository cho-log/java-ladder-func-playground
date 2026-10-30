package domain;

import java.util.List;

public class Outcomes {
    private final List<Outcome> outcomes;

    public Outcomes(List<Outcome> outcomes) {
        this.outcomes = List.copyOf(outcomes);
    }

    public int getSize() {
        return outcomes.size();
    }

    public Outcome getOutcomeByPosition(Position position) {
        return outcomes.get(position.getValue());
    }
}
