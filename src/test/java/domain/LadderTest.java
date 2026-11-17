package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("사다리 생성 테스트 4줄일 경우 정상 수행")
    @Test
    public void creationTest() {
        Ladder ladder = new Ladder(new Size(4),new Size(4));
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

    @DisplayName("사다리 연결되었을 경우, 이웃 참가자 결과 swap 수행")
    @Test
    public void getResultTest() {
        List<Participant> participantList = new ArrayList<Participant>();
        for (int i = 0; i < 4; i++) {
            participantList.add(new Participant(i));
        }
        Participants participants = new Participants(participantList);
        List<Point> points = List.of(new Point(true), new Point(false), new Point(true));
        Line line = new Line(points);
        Ladder ladder = new Ladder(List.of(line));
        ladder.getResult(participants);

        assertThat(participants.getParticipants().get(0).getEnd()).isEqualTo(1);
        assertThat(participants.getParticipants().get(1).getEnd()).isEqualTo(0);
        assertThat(participants.getParticipants().get(2).getEnd()).isEqualTo(3);
        assertThat(participants.getParticipants().get(3).getEnd()).isEqualTo(2);
    }
}
