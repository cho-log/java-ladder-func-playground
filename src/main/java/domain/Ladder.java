package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Size ladderSize, Size lineSize) {
        this.lines = generateLines(ladderSize, lineSize);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> generateLines(Size ladderSize, Size lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderSize.getSize(); i++) {
            lines.add(new Line(lineSize));
        }
        return lines;
    }

    public void getResult(Participants participants){
        for (Line line : lines) {
            changeByLine(line, participants.getParticipants());
        }
    }

    private void changeByLine(Line line, List<Participant> participants){
        for(int i = 0; i< line.getPoints().size() ; i++){
            changeByPoint(i,line.getPoints().get(i), participants);
        }
    }

    private void changeByPoint(int idx, Point point, List<Participant> participants){
        if(point.isConnected()){
            move(idx, participants);
        }
    }

    private void move(int idx, List<Participant> participants){
        int temp = participants.get(idx).getEnd();
        participants.get(idx).changeEnd(participants.get(idx+1).getEnd());
        participants.get(idx+1).changeEnd(temp);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return lines.get(0).getPoints().size()+1;
    }

}
