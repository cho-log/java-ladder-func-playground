package exception;

public enum ErrorMessage {
    HEIGHT_IS_NOT_INTEGER("높이는 정수여야 합니다."),
    MINIMUM_WIDTH("넓이는 1 이상이어야 합니다."),
    MINIMUM_HEIGHT("높이는 1 이상이어야 합니다."),
    POSITION_IS_NEGATIVE("위치는 0 이상이어야 합니다."),
    NAME_IS_EMPTY("이름은 비워둘 수 없습니다."),
    PRIZE_IS_EMPTY("실행 결과는 비워둘 수 없습니다."),
    NAME_TOO_LONG("이름은 5자 이하여야 합니다."),
    PRIZE_COUNT_MISMATCH("실행 결과 개수는 이름 개수와 동일해야 합니다."),
    NAME_NOT_FOUND("이름이 목록에 존재하지 않습니다."),
    DUPLICATE_NAME("참여자의 이름은 중복이 허용되지 않습니다."),
    NAME_IS_RESERVED("전체 조회 명령어는 참여자의 이름이 될 수 없습니다."),
    NOT_ENOUGH_PARTICIPANTS("참여자는 2명 이상이어야 합니다."),
    POSITION_OUT_OF_LADDER("위치가 사다리 넓이를 벗어났습니다."),
    LADDER_WIDTH_MISMATCH("사다리 넓이는 참여자 수와 같아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
