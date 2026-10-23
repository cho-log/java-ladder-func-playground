package domain;

//줄안의 칸 하나
//point는 연결되어있는지 아닌지 판단.
//boolean을 감쌋다고 볼 수 있음
public class Point {
    private final boolean connected;

    private Point(boolean connected) {
        this.connected = connected;
    }

    //connected()
    public static Point connected() {
        return new Point(true);
    }

    //static은 객체에 속한 메서드가 아니라 클래스에 속한 메서드라는 뜻입니다. 객체 없이 클래스이름.메서드()로 부를 수 있습니다.
    //disconnected()
    public static Point disconnected() {
        return new Point(false);
    }

    public boolean isConnected() {
        return connected;
    }
}
