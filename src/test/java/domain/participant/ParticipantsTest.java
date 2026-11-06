package domain.participant;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ParticipantsTest {
    @Test
    void 참여자_수를_반환한다() {
        // given & when
        Participants participants = createParticipants();

        // then
        assertEquals(4, participants.getSize());
    }

    @Test
    void 이름으로_참여자를_조회한다() {
        // given
        Participants participants = createParticipants();
        String findName = "neo";

        // when
        Participant result = participants.getParticipant(findName);

        // then
        assertEquals(findName, result.getName());
    }

    @Test
    void 존재하지_않는_참여자를_조회하면_예외가_발생한다() {
        // given
        Participants participants = createParticipants();
        String findName = "red";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> participants.getParticipant(findName));
    }

    @Test
    void 참여자_이름이_중복되면_예외가_발생한다() {
        // given
        Participant participant1 = new Participant("neo");
        Participant participant2 = new Participant("neo");

        // when
        List<Participant> participants = List.of(participant1, participant2);

        // then
        assertThrows(IllegalArgumentException.class, () -> new Participants(participants));
    }

    @Test
    void 공백을_제거한_참여자_이름이_중복되면_예외가_발생한다() {
        // given
        Participant participant1 = new Participant("neo");
        Participant participant2 = new Participant("   neo   ");

        // when
        List<Participant> participants = List.of(participant1, participant2);

        // then
        assertThrows(IllegalArgumentException.class, () -> new Participants(participants));
    }


    private Participants createParticipants() {
        return new Participants(List.of(
                new Participant("neo"),
                new Participant("brown"),
                new Participant("brie"),
                new Participant("tommy")
        ));
    }
}
