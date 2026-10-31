package domain.outcome;

public class Outcome {
    private final String outcome;

    public Outcome(String outcome) {
        String normalizedOutcome = normalize(outcome);
        validateOutcome(normalizedOutcome);
        this.outcome = normalizedOutcome;
    }

    private String normalize(String outcome) {
        if (outcome == null) {
            throw new IllegalArgumentException("결과를 입력해야 합니다.");
        }

        return outcome.trim();
    }

    private void validateOutcome(String outcome) {
        if (outcome.isEmpty()) {
            throw new IllegalArgumentException("결과를 입력해야 합니다.");
        }
    }

    public String getOutcome() {
        return outcome;
    }
}
