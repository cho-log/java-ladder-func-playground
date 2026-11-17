package view;
import domain.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    // 참여자 입력
    public static ArrayList<Participant> inputParticipants(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participantsInput = scanner.nextLine();

        ArrayList<String> names = new ArrayList<>(Arrays.asList(participantsInput.split(",")));

        ArrayList<Participant> participants = new ArrayList<>();
        for (String name : names) {
            participants.add(new Participant(name));
        }

        System.out.println();

        return participants;
    }

    // 실행 결과 입력
    public static ArrayList<String> inputResults(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String participantsInput = scanner.nextLine();

        ArrayList<String> results = new ArrayList<>(Arrays.asList(participantsInput.split(",")));

        System.out.println();

        return results;
    }

    // 사다리 높이 입력
    public static int inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        return height;
    }

    // 결과 검색
    public static String searchResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String search = scanner.nextLine();

        System.out.println();

        return search;
    }
}
