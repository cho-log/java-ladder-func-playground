package domain;

import domain.participant.Participant;
import domain.participant.Participants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abcdef", "all"})
    void rejectsInvalidName(String name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void acceptsFiveCharactersAndTrimsWhitespace() {
        assertThat(new Participant(" brown ").getValue()).isEqualTo("brown");
        assertThat(new Participant(" neo ")).isEqualTo(new Participant("neo"));
    }

    @Test
    void rejectsDuplicateNamesAfterTrimming() {
        assertThatThrownBy(() -> new Participants(List.of("neo", " neo ")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsEmptyParticipants() {
        assertThatThrownBy(() -> new Participants(List.of())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void preservesInputOrderAndUsesParticipantCountAsWidth() {
        Participants participants = new Participants(List.of("neo", "brown", "brie"));
        assertThat(participants.getNames()).extracting(Participant::getValue)
                .containsExactly("neo", "brown", "brie");
        assertThat(participants.getWidth().getValue()).isEqualTo(3);
    }
}
