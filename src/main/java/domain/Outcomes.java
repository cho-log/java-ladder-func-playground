package domain;

import java.util.List;

public class Outcomes {
    private final List<Outcome> values;

    public Outcomes(List<String> values) {
        this.values = createOutcomes(values);
    }

    private List<Outcome> createOutcomes(List<String> values) {
        return values.stream().map(Outcome::new).toList();
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
