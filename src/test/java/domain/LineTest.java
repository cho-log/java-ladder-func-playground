package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.random.ConnectionGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {
    private static final ConnectionGenerator ALWAYS_CONNECTED = () -> Connection.CONNECTED;
    private static final ConnectionGenerator NEVER_CONNECTED = () -> Connection.NOT_CONNECTED;

    @Test
    void 칸_개수는_넓이보다_1_작다() {
        Line line = Line.createLine(new Width(4), ALWAYS_CONNECTED);

        assertThat(line.getConnections()).hasSize(3);
    }

    @Test
    void 생성기가_항상_연결을_줘도_가로선은_겹치지_않는다() {
        Line line = Line.createLine(new Width(4), ALWAYS_CONNECTED);

        assertThat(line.getConnections()).containsExactly(
                Connection.CONNECTED, Connection.NOT_CONNECTED, Connection.CONNECTED);
    }

    @Test
    void 오른쪽_칸이_연결되어_있으면_오른쪽으로_이동한다() {
        Line line = Line.createLine(new Width(4), ALWAYS_CONNECTED);

        assertThat(line.move(new Position(0)).getPosition()).isEqualTo(1);
    }

    @Test
    void 왼쪽_칸이_연결되어_있으면_왼쪽으로_이동한다() {
        Line line = Line.createLine(new Width(4), ALWAYS_CONNECTED);

        assertThat(line.move(new Position(1)).getPosition()).isEqualTo(0);
    }

    @Test
    void 양쪽_칸이_모두_연결되지_않으면_그대로_있는다() {
        Line line = Line.createLine(new Width(4), NEVER_CONNECTED);

        assertThat(line.move(new Position(1)).getPosition()).isEqualTo(1);
    }
}
