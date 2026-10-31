package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EndPositionsTest {

    @Test
    void 시작_위치의_순서에_있는_도착_위치를_찾는다() {
        EndPositions endPositions = new EndPositions(
                List.of(new Position(2), new Position(0), new Position(1)));

        Position endPosition = endPositions.findEndPosition(new Position(0));

        assertThat(endPosition.getPosition()).isEqualTo(2);
    }
}
