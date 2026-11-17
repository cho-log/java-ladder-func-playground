package service;

import domain.Ladder;
import domain.Participant;
import domain.Participants;
import domain.Size;
import java.util.ArrayList;
import java.util.List;

public class LadderService {

    public Ladder createLadder(int height, int width) {
        Size heightSize = new Size(height);
        Size widthSize = new Size(width);
        return new Ladder(heightSize, widthSize);
    }

    public Participants createParticipants(int width) {
        List<Participant> participants = new ArrayList<>();
        for(int i = 0 ; i< width; i++){
            participants.add(new Participant(i));
        }
        return new Participants(participants);
    }

    public void getResult(Ladder ladder, Participants participants) {
        ladder.getResult(participants);
    }
}
