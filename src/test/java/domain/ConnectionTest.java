package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionTest {
    @ParameterizedTest
    @CsvSource({"true, CONNECTED", "false, DISCONNECTED"})
    void convertsGeneratedValue(boolean connected, Connection expected) {
        assertThat(Connection.from(connected)).isEqualTo(expected);
    }

    @Test
    void disconnectsAfterConnectedSection() {
        // 실행
        Connection next = Connection.CONNECTED.next(() -> Connection.CONNECTED);
        // 검증
        assertThat(next).isEqualTo(Connection.DISCONNECTED);
    }

    @ParameterizedTest
    @CsvSource({"CONNECTED", "DISCONNECTED"})
    void usesGeneratorAfterDisconnectedSection(Connection generated) {
        // 실행
        Connection next = Connection.DISCONNECTED.next(() -> generated);
        // 검증
        assertThat(next).isEqualTo(generated);
    }
}
