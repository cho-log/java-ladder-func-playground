package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getLadderWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        int width = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return width;
    }

    public int getLadderHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return height;
    }
}
