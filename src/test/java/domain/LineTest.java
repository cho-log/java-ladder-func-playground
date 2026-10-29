package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void preventsAdjacentConnections() {
        // 준비
        Line line = new Line(() -> Connection.CONNECTED);
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED);
    }

    @Test
    void keepsAllSectionsDisconnected() {
        // 준비
        Line line = new Line(() -> Connection.DISCONNECTED);
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.DISCONNECTED, Connection.DISCONNECTED, Connection.DISCONNECTED);
    }

    @Test
    void connectsMiddleSectionWithoutConnectingLastSection() {
        // 준비
        Line line = new Line(new FixedConnectionGenerator(
                List.of(Connection.DISCONNECTED, Connection.CONNECTED)));
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.DISCONNECTED, Connection.CONNECTED, Connection.DISCONNECTED);
    }
}
