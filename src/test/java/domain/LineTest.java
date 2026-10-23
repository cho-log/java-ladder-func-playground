package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("지정한 개수만큼 지점이 생성된다.")
    void 지정한_개수만큼_지점이_생성된다() {
        Line line = Line.create(new LadderSize(3), () -> true);

        assertThat(line.points()).hasSize(3);
    }

    @Test
    @DisplayName("항상 true여도 연속해서 연결되지 않는다.")
    void 항상_true여도_연속해서_연결되지_않는다() {
        Line line = Line.create(new LadderSize(3), () -> true);

        List<Point> points = line.points();

        assertThat(points.get(0).isConnected()).isTrue();
        assertThat(points.get(1).isConnected()).isFalse();
        assertThat(points.get(2).isConnected()).isTrue();
    }

    @Test
    @DisplayName("항상 false면 모두 연결되지 않는다.")
    void 항상_false면_모두_연결되지_않는다() {
        Line line = Line.create(new LadderSize(3), () -> false);

        List<Point> points = line.points();

        assertThat(points.get(0).isConnected()).isFalse();
        assertThat(points.get(1).isConnected()).isFalse();
        assertThat(points.get(2).isConnected()).isFalse();
    }

    @Test
    @DisplayName("랜덤으로 만들어도 연속해서 연결되지 않는다.")
    void 랜덤으로_만들어도_연속해서_연결되지_않는다() {
        for (int count = 0; count < 100; count++) {
            Line line = Line.create(new LadderSize(3), new RandomBooleanGenerator());

            assertThat(hasAdjacentConnection(line)).isFalse();
        }
    }

    private boolean hasAdjacentConnection(Line line) {
        for (int index = 1; index < line.points().size(); index++) {
            if (line.points().get(index - 1).isConnected() && line.points().get(index).isConnected()) {
                return true;
            }
        }
        return false;
    }
}
