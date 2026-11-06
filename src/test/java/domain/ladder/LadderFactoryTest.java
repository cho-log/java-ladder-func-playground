package domain.ladder;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderFactoryTest {
    @Test
    void 입력받은_너비와_높이로_사다리가_생성된다() {
        // given
        LadderFactory ladderFactory = new LadderFactory(new ConnectionGenerator());
        Width width = new Width(4);
        Height height = new Height(5);

        // when
        Ladder ladder = ladderFactory.createLadder(width, height);

        // then
        assertEquals(5, ladder.getLines().size());
        for (Line line : ladder.getLines()) {
            assertEquals(3, line.getPoints().size());
        }
    }

    @Test
    void 최소_너비와_높이로_사다리를_생성할_수_있다() {
        // given
        LadderFactory ladderFactory = new LadderFactory(new ConnectionGenerator());
        Width width = new Width(2);
        Height height = new Height(1);

        // when
        Ladder ladder = ladderFactory.createLadder(width, height);

        // then
        assertEquals(1, ladder.getLines().size());
        assertEquals(1, ladder.getLines().get(0).getPoints().size());
    }
}
