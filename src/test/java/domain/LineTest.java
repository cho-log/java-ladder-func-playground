package domain;

import domain.connection.Connection;
import domain.ladder.LadderWidth;
import domain.ladder.Line;
import domain.ladder.Position;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void preventsAdjacentConnections() {
        // 준비
        Line line = new Line(new LadderWidth(4), () -> Connection.CONNECTED);
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED);
    }

    @Test
    void keepsAllSectionsDisconnected() {
        // 준비
        Line line = new Line(new LadderWidth(4), () -> Connection.DISCONNECTED);
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.DISCONNECTED, Connection.DISCONNECTED, Connection.DISCONNECTED);
    }

    @Test
    void connectsMiddleSectionWithoutConnectingLastSection() {
        // 준비
        Line line = new Line(new LadderWidth(4), new FixedConnectionGenerator(
                List.of(Connection.DISCONNECTED, Connection.CONNECTED)));
        // 검증
        assertThat(line.getConnections()).containsExactly(
                Connection.DISCONNECTED, Connection.CONNECTED, Connection.DISCONNECTED);
    }
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 3", "3, 2"})
    void movesLeftOrRightOncePerLine(int start, int expected) {
        Line line = new Line(new LadderWidth(4), () -> Connection.CONNECTED);
        assertThat(line.move(new Position(start)).getValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void staysWhenNoConnectionExists(int start) {
        Line line = new Line(new LadderWidth(4), () -> Connection.DISCONNECTED);
        assertThat(line.move(new Position(start)).getValue()).isEqualTo(start);
    }

}
