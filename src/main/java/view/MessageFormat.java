package view;

public enum MessageFormat {

    INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_PRIZES("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
    INPUT_TARGET("결과를 보고 싶은 사람은?"),
    RESULT_LADDER("사다리 결과"),
    RESULT_TITLE("실행 결과"),
    RESULT_SEPARATOR(" : ");

    private final String message;

    MessageFormat(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
