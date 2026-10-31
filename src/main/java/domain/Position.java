package domain;

//사다리를 타는 사람이 지금 몇 번째 세로줄에 서 있는지"를 나타내는 클래스
public class Position {

    private static final int MINIMUM_POSITION = 0; //세로줄 번호의 최소값은 0부터 시작한다.
    private static final int MOVE_DISTANCE = 1; //세로줄 번호는 1칸씩 이동한다.

    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) { //세로줄 번호의 최소값은 0부터 시작한다.
        if (value < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치는 " + MINIMUM_POSITION + " 이상이어야 합니다.");
        }
    }

    //왼쪽 오른쪽 이동할때마다 새로운객체를 만들어서 반환함
    public Position moveLeft() {
        return new Position(value - MOVE_DISTANCE);
    }

    public Position moveRight() {
        return new Position(value + MOVE_DISTANCE);
    }

    public int value() {
        return value;
    }

}
