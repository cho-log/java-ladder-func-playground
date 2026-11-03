package domain;

import domain.ladder.LadderWidth;
import domain.result.Outcome;
import domain.result.Outcomes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OutcomesTest {
    @Test
    void createsOutcomesMatchingParticipantCount() {
        // 준비
        List<String> values = List.of("꽝", "5000");
        // 실행
        Outcomes outcomes = Outcomes.of(new LadderWidth(2), values);
        // 검증
        assertThat(outcomes.getValues()).extracting(Outcome::getValue)
                .containsExactly("꽝", "5000");
    }

    @Test
    void rejectsCountMismatchAtCreation() {
        // 준비
        List<String> values = List.of("꽝");
        // 실행 및 검증
        assertThatThrownBy(() -> Outcomes.of(new LadderWidth(2), values))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
