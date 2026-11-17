package domain;

public class Participant {
    String name;
    String result;

    public Participant(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
