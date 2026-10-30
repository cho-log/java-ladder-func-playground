package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final ArrayList<Line> lines;
    private final int width;

    public Ladder(int width,int height) {
        lines=new ArrayList<>();
        this.width=width;
        generateLines(height);
    }

    public void generateLines(int height){
        for (int i = 0; i < height ; i++) {
            lines.add(new Line(width));
        }
    }
    public int move(int position){

        for(Line line: lines){
            position=line.moveLine(position);
        }
        return position;
    }

    public List<Line> getLines(){
        return List.copyOf(lines);
    }

    public int getWidth(){
        return width;
    }
}
