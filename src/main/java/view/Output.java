package view;

import domain.Participant;

import java.util.ArrayList;

public class Output {

    // 참여자 출력
    public static void printParticipants(ArrayList<Participant> participants){
        System.out.println("사다리 결과\n");
        for(Participant p : participants){
            System.out.print(" " + p.getName());
        }
    }

    // 실행 결과 출력
    public static void printResults(ArrayList<String> results){
        for(String r : results){
            System.out.print(" " + r);
        }
        System.out.println();
        System.out.println();
    }

    // 사다리 출력 1
    public static void printLadder(ArrayList<ArrayList<Integer>> array2D) {
        for (ArrayList<Integer> row : array2D) {
            printRow(row);
        }
    }

    // 사다리 출력 2
    private static void printRow(ArrayList<Integer> row) {
        System.out.print(" |");
        for (int val : row) {
            printRowLadder(val);
            System.out.print("|");
        }
        System.out.println();
    }

    // 사다리 출력 3
    private static void printRowLadder(int val) {
        if(val == 1)
            System.out.print("-----");
        if(val == 0)
            System.out.print("     ");
    }

    // 개별 참가자의 결과 출력 1
    public static void printResultForParticipant(ArrayList<Participant> participants, String name) {
        System.out.println("실행 결과");
        for (Participant p : participants) {
            printResultForParticipant2(p, name);
        }
        System.out.println();
    }

    // 개별 참가자의 결과 출력 2
    public static void printResultForParticipant2 (Participant p, String name){
        if (p.getName().equalsIgnoreCase(name)) {
            System.out.println(p.getResult());
        }
    }

    // 모든 참가자의 결과 출력
    public static void printAllResults(ArrayList<Participant> participants) {
        System.out.println("실행 결과");
        for (Participant p : participants) {
            System.out.println(p.getName() + " : " + p.getResult());
        }
        System.out.println();
    }
}
