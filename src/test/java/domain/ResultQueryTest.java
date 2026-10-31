package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultQueryTest {
    @Test
    void distinguishesAllFromIndividualName() {
        assertThat(new ResultQuery(" all ").isAll()).isTrue();
        assertThat(new ResultQuery("neo").isAll()).isFalse();
        assertThat(new ResultQuery(" neo ").getName()).isEqualTo(new ParticipantName("neo"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void rejectsBlankQuery(String query) {
        assertThatThrownBy(() -> new ResultQuery(query)).isInstanceOf(IllegalArgumentException.class);
    }
}
