package domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    void rejectsNegativePosition() {
        // 실행 및 검증
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
