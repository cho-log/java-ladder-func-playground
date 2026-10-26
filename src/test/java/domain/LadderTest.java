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

    @Test
    @DisplayName("줄이 홀수 개면 연결된 칸을 한 번 건넌다.")
    //이렇게 하면 [연결, 안, 연결] 형태로만 생성됨.
    void 줄이_홀수_개면_위치가_바뀐다() {
        Ladder ladder = Ladder.create(new LadderSize(3), new LadderSize(4), () -> true);

        assertThat(ladder.climb(new Position(0)).value()).isEqualTo(1);
        assertThat(ladder.climb(new Position(1)).value()).isEqualTo(0);
        assertThat(ladder.climb(new Position(2)).value()).isEqualTo(3);
        assertThat(ladder.climb(new Position(3)).value()).isEqualTo(2);
    }

    @Test
    @DisplayName("줄이 짝수 개면 원래 위치로 돌아온다.")
    void 줄이_짝수_개면_원래_위치로_돌아온다() {
        Ladder ladder = Ladder.create(new LadderSize(2), new LadderSize(4), () -> true);

        assertThat(ladder.climb(new Position(0)).value()).isEqualTo(0);
        assertThat(ladder.climb(new Position(1)).value()).isEqualTo(1);
    }

    @Test
    @DisplayName("연결이 없으면 출발 위치와 도착 위치가 같다.")
    void 연결이_없으면_도착_위치가_같다() {
        Ladder ladder = Ladder.create(new LadderSize(4), new LadderSize(4), () -> false);

        assertThat(ladder.climb(new Position(2)).value()).isEqualTo(2);
    }
}
