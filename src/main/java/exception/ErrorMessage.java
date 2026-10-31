package exception;

public enum ErrorMessage {
    WIDTH_IS_NOT_INTEGER("넓이는 정수여야 합니다."),
    HEIGHT_IS_NOT_INTEGER("높이는 정수여야 합니다."),
    WIDTH_IS_BIGGER_THAN_2("넓이는 2 이상이어야 합니다."),
    HEIGHT_IS_BIGGER_THAN_0("높이는 1 이상이어야 합니다."),
    POSITION_IS_NEGATIVE("위치는 0 이상이어야 합니다."),
    NAME_IS_EMPTY("이름은 비워둘 수 없습니다."),
    PRIZE_IS_EMPTY("실행 결과는 비워둘 수 없습니다."),
    NAME_TOO_LONG("이름은 5자 이하여야 합니다."),
    PRIZE_NUMBER_IS_NOT_NAME_NUMBER("실행 결과 개수는 이름 개수와 동일해야 합니다."),
    NOT_IN_NAMES("결과를 보고싶은 사람은 참여할 사람 내에 있는 사람이어야 합니다."),
    NAME_NOT_FOUND("이름이 목록에 존재하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
