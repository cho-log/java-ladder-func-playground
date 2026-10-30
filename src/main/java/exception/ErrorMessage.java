package exception;

public enum ErrorMessage {
    WIDTH_IS_NOT_INTEGER("넓이는 정수여야 합니다."),
    HEIGHT_IS_NOT_INTEGER("높이는 정수여야 합니다."),
    WIDTH_IS_BIGGER_THAN_2("넓이는 2 이상이어야 합니다."),
    HEIGHT_IS_BIGGER_THAN_0("높이는 1 이상이어야 합니다."),
    POSITION_IS_NEGATIVE("위치는 0 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
