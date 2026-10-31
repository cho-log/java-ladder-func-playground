package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderSizeTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void rejectsInvalidWidth(int value) {
        assertThatThrownBy(() -> new LadderWidth(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void rejectsInvalidHeight(int value) {
        assertThatThrownBy(() -> new LadderHeight(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 3", "5, 2"})
    void createsRequestedSize(int width, int height) {
        Ladder ladder = new Ladder(new LadderWidth(width), new LadderHeight(height), () -> Connection.CONNECTED);
        assertThat(ladder.getLines()).hasSize(height);
        assertThat(ladder.getLines()).allSatisfy(line ->
                assertThat(line.getConnections()).hasSize(width - 1));
    }
}
