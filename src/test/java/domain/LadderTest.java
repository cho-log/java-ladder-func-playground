package domain;

import domain.connection.Connection;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderWidth;
import domain.ladder.Position;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    void createsFourLines() {
        // 준비
        Ladder ladder = new Ladder(new LadderWidth(4), new LadderHeight(4), () -> Connection.DISCONNECTED);
        // 검증
        assertThat(ladder.getLines()).hasSize(4);
    }

    @Test
    void startsEachLineWithoutConnectionFromPreviousLine() {
        // 준비
        Ladder ladder = new Ladder(new LadderWidth(4), new LadderHeight(4), () -> Connection.CONNECTED);
        // 검증
        assertThat(ladder.getLines()).allSatisfy(line ->
                assertThat(line.getConnections()).containsExactly(
                        Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED));
    }
    @Test
    void followsSeveralLinesFromTopToBottom() {
        Ladder ladder = createCrossingLadder();
        assertThat(ladder.getPaths()).extracting(path -> path.getEnd().getValue())
                .containsExactly(2, 0, 1);
    }

    @Test
    void keepsAllDestinationsUnique() {
        Ladder ladder = createCrossingLadder();
        assertThat(ladder.getPaths()).extracting(path -> path.getEnd().getValue())
                .doesNotHaveDuplicates().hasSize(3);
    }

    @Test
    void supportsSingleVerticalLine() {
        Ladder ladder = new Ladder(new LadderWidth(1), new LadderHeight(2), () -> Connection.CONNECTED);
        assertThat(ladder.move(new Position(0)).getValue()).isZero();
    }

    @Test
    void rejectsStartOutsideLadder() {
        Ladder ladder = createCrossingLadder();
        assertThatThrownBy(() -> ladder.move(new Position(3))).isInstanceOf(IllegalArgumentException.class);
    }

    private Ladder createCrossingLadder() {
        return new Ladder(new LadderWidth(3), new LadderHeight(2),
                new FixedConnectionGenerator(List.of(
                        Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED)));
    }
}
