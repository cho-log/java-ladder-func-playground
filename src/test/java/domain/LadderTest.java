package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void createsFourLines() {
        // 준비
        Ladder ladder = new Ladder(() -> Connection.DISCONNECTED);
        // 검증
        assertThat(ladder.getLines()).hasSize(4);
    }

    @Test
    void startsEachLineWithoutConnectionFromPreviousLine() {
        // 준비
        Ladder ladder = new Ladder(() -> Connection.CONNECTED);
        // 검증
        assertThat(ladder.getLines()).allSatisfy(line ->
                assertThat(line.getConnections()).containsExactly(
                        Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED));
    }
}
