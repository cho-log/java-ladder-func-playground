package domain;

import java.util.ArrayList;
import java.util.List;

public class Outcomes {
    private final List<Outcome> values;

    public Outcomes(List<String> values) {
        this.values = createOutcomes(values);
    }

    private List<Outcome> createOutcomes(List<String> values) {
        List<Outcome> outcomes = new ArrayList<>();
        for (String value : values) {
            outcomes.add(new Outcome(value));
        }
        return List.copyOf(outcomes);
    }

    public void validateCount(LadderWidth width) {
        if (values.size() != width.getValue()) {
            throw new IllegalArgumentException("실행 결과 개수는 참여자 수와 같아야 합니다.");
        }
    }

    public Outcome get(Position position) {
        return values.get(position.getValue());
    }

    public List<Outcome> getValues() {
        return values;
    }
}
