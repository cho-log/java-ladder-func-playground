package view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner=new Scanner(System.in);

    public static int inputWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return toInt(scanner.nextLine());
    }

    public static int inputHeight(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        return toInt(scanner.nextLine());
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
