package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.random.ConnectionGenerator;
import domain.random.RandomConnectionGenerator;
import exception.ErrorMessage;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
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
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(1), ALWAYS_CONNECTED);

        assertThat(findEndNumbers(ladder)).containsExactly(1, 0, 3, 2);
    }

    @Test
    void 연결된_칸이_없으면_시작_위치에_그대로_도착한다() {
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(3), NEVER_CONNECTED);

        assertThat(findEndNumbers(ladder)).containsExactly(0, 1, 2, 3);
    }

    @Test
    void 사다리는_자신의_넓이를_알려준다() {
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(5), ALWAYS_CONNECTED);

        assertThat(ladder.width()).isEqualTo(4);
    }

    @Test
    void 사다리_넓이를_벗어난_위치는_오류가_발생한다() {
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(5), ALWAYS_CONNECTED);

        assertThatThrownBy(() -> ladder.findEndPosition(new Position(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.POSITION_OUT_OF_LADDER.getMessage());
    }

    @RepeatedTest(100)
    void 어떤_사다리든_도착_위치는_겹치지_않는다(RepetitionInfo repetitionInfo) {
        Random random = new Random(repetitionInfo.getCurrentRepetition());
        Ladder ladder = Ladder.createLadder(new Width(4), new Height(5), new RandomConnectionGenerator(random));

        assertThat(findEndNumbers(ladder)).containsExactlyInAnyOrder(0, 1, 2, 3);
    }

    private List<Integer> findEndNumbers(Ladder ladder) {
        return IntStream.range(0, ladder.width())
                .mapToObj(Position::new)
                .map(ladder::findEndPosition)
                .map(Position::getPosition)
                .toList();
    }
}
