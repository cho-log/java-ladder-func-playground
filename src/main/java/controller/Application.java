package controller;

import domain.LadderArray;
import domain.Participant;
import view.Input;
import view.Output;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        // 참여자 입력
        ArrayList<Participant> participants = Input.inputParticipants();

        // 실행 결과 입력
        ArrayList<String> results = Input.inputResults();

        // 사다리 높이 입력
        int height = Input.inputHeight();

        // 참여자 출력
        Output.printParticipants(participants);

        // 가로 사다리 배열 만들기
        ArrayList<ArrayList<Integer>> array = LadderArray.createLadderArray(participants.size()-1, height);

        // 사다리 출력
        Output.printLadder(array);

        // 실행 결과 출력
        Output.printResults(results);

        // 각 참가자의 최종 결과 구하기
        LadderArray.setResultsForParticipants(participants, results, array);

        // 반복 검색
        while(true){
            // 검색
            search(participants);
        }
    }

    // 검색
    private static void search(ArrayList<Participant> participants) {
        // 결과 검색
        String search = Input.searchResult();
        if (search.equalsIgnoreCase("all")) {
            // 모든 참가자의 결과 출력
            Output.printAllResults(participants);
        }
        if (! search.equalsIgnoreCase("all")) {
            // 개별 참가자의 결과 출력
            Output.printResultForParticipant(participants, search);
        }
    }
}