package view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "", "2147483648"})
    void rejectsInvalidInteger(String input) {
        assertThatThrownBy(() -> InputView.readInteger(new Scanner(input + "\n")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", " 5 "})
    void readsPositiveSize(String input) {
        assertThat(InputView.readHeight(new Scanner(input)).getValue())
                .isEqualTo(Integer.parseInt(input.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"neo,", ",neo", "neo,,brie"})
    void rejectsEmptyNameInCommaSeparatedInput(String input) {
        assertThatThrownBy(() -> InputView.readParticipants(new Scanner(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,", ",5000", "꽝,,5000"})
    void rejectsEmptyOutcomeInCommaSeparatedInput(String input) {
        assertThatThrownBy(() -> InputView.readOutcomes(new Scanner(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
