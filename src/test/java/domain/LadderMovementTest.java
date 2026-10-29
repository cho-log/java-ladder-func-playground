package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMovementTest {
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
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    private Ladder createCrossingLadder() {
        return new Ladder(new LadderWidth(3), new LadderHeight(2),
                new FixedConnectionGenerator(List.of(
                        Connection.CONNECTED, Connection.DISCONNECTED, Connection.CONNECTED)));
    }
}
