package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;
    private static final Random random=new Random();

    public Line(int width) {
        points=new ArrayList<>();
        generateLine(width-1);
    }

    private void generateLine(int width){
        for(int i=0;i<width;i++)
            addPoint(i);
    }

    private void addPoint(int index){
        if(index>0 && points.get(index-1)) {
            points.add(false);
            return;
        }
        points.add(random.nextBoolean());
    }
    public int moveLine(int index){
        if(index > 0 && points.get(index-1))
            return index-1;
        if(index< points.size() && points.get(index))
            return index+1;
        return index;
    }
    public List<Boolean> getLine(){
        return points;
    }
}
