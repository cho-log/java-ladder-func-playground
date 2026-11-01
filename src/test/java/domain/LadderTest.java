package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.random.ConnectionGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {
    private static final ConnectionGenerator ALWAYS_CONNECTED = () -> Connection.CONNECTED;
    private static final ConnectionGenerator NEVER_CONNECTED = () -> Connection.NOT_CONNECTED;

    @Test
    void 높이만큼_줄이_생성된다() {
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(5), ALWAYS_CONNECTED);

        assertThat(ladder.getLines()).hasSize(5);
    }

    @Test
    void 연결된_칸을_따라_도착_위치가_바뀐다() {
        Width width = new Width(4);
        Ladder ladder = Ladder.createLadder(width, new Height(1), ALWAYS_CONNECTED);

        assertThat(toNumbers(ladder.findEndPositions())).containsExactly(1, 0, 3, 2);
    }

    @Test
    void 연결된_칸이_없으면_시작_위치에_그대로_도착한다() {
        Width width = new Width(4);
        Ladder ladder = Ladder.createLadder(width, new Height(3), NEVER_CONNECTED);

        assertThat(toNumbers(ladder.findEndPositions())).containsExactly(0, 1, 2, 3);
    }

    private List<Integer> toNumbers(EndPositions endPositions) {
        return endPositions.getEndPositions().stream()
                .map(Position::getPosition)
                .toList();
    }
}
