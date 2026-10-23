package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("높이만큼 줄이 생성된다.")
    void 높이만큼_줄이_생성된다() {
        Ladder ladder = Ladder.create(new LadderSize(4), new LadderSize(4), () -> true);

        assertThat(ladder.lines()).hasSize(4);
    }

    @Test
    @DisplayName("각 줄은 너비만큼 지점을 가진다.")
    void 각_줄은_너비만큼_지점을_가진다() {
        Ladder ladder = Ladder.create(new LadderSize(4), new LadderSize(4), () -> true);

        List<Line> lines = ladder.lines();

        assertThat(lines.get(0).points()).hasSize(3);
        assertThat(lines.get(3).points()).hasSize(3);
    }
}
