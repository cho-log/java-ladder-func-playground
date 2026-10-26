package view;

public enum MessageFormat {

    INPUT_HEIGHT("사다리 높이는 몇 개인가요?"),
    INPUT_WIDTH("사다리 너비는 몇 개인가요?"),
    RESULT_ARROW(" -> ");

    private final String message;

    MessageFormat(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
