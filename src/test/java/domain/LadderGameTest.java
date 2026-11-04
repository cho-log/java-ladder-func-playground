package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    @DisplayName("출발 위치 개수만큼 도착 위치가 나온다.")
    void 출발_위치_개수만큼_결과가_나온다() {
        Ladder ladder = Ladder.create(new LadderSize(3), new LadderSize(4), () -> true);

        LadderResult result = new LadderGame(ladder).play();

        assertThat(result.arrivals()).hasSize(4);
    }

    @Test
    @DisplayName("각 출발 위치의 도착 위치를 모은다.")
    void 각_출발_위치의_도착_위치를_모은다() {
        Ladder ladder = Ladder.create(new LadderSize(3), new LadderSize(4), () -> true);

        List<Position> arrivals = new LadderGame(ladder).play().arrivals();

        assertThat(arrivals.get(0).value()).isEqualTo(1);
        assertThat(arrivals.get(1).value()).isEqualTo(0);
        assertThat(arrivals.get(2).value()).isEqualTo(3);
        assertThat(arrivals.get(3).value()).isEqualTo(2);
    }
}
