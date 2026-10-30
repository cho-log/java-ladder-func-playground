package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ParticipantTest {
    @Test
    void 정상적인_이름으로_사용자를_생성한다() {
        // given
        String name = "abc";

        // when
        Participant participant = new Participant(name);

        // then
        assertEquals(name, participant.getName());
    }

    @Test
    void 이름이_빈_문자열이면_예외가_발생한다() {
        // given
        String name = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @Test
    void 이름이_공백이면_예외가_발생한다() {
        // given
        String name = "   ";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @Test
    void 이름이_5글자가_넘으면_예외가_발생한다() {
        // given
        String name = "abcdef";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @Test
    void 이름의_앞뒤_공백이_제거되어서_저장된다() {
        // given
        String name = "    abc   ";

        // when
        Participant participant = new Participant(name);

        // then
        assertEquals("abc", participant.getName());
    }
}
