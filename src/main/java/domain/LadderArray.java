package domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderArray {

    // 가로 사다리 배열 만들기 1
    public static ArrayList<ArrayList<Integer>> createLadderArray(int x, int y) {
        System.out.println();
        ArrayList<ArrayList<Integer>> array2D = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            array2D.add(generateRow(x));
        }

        return array2D;
    }

    // 가로 사다리 배열 만들기 2
    private static ArrayList<Integer> generateRow(int x) {
        ArrayList<Integer> row = new ArrayList<>();
        Random random = new Random();

        int previousValue = 0;
        for (int j = 0; j < x; j++) {
            int currentValue = generateValue(random, previousValue);
            row.add(currentValue);
            previousValue = currentValue;
        }

        return row;
    }

    // 가로 사다리 배열 만들기 3
    private static int generateValue(Random random, int previousValue) {
        int value = random.nextInt(2);
        if (previousValue == 1 && value == 1) {
            value = 0;
        }
        return value;
    }

    // 각 참가자의 최종 결과를 구하기 1
    public static void setResultsForParticipants(ArrayList<Participant> participants, ArrayList<String> results, ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < participants.size(); i++) {
            int finalPosition = findFinalPosition(i, array);
            participants.get(i).setResult(results.get(finalPosition));
        }
    }

    // 각 참가자의 최종 결과 구하기 2
    private static int findFinalPosition(int startIndex, ArrayList<ArrayList<Integer>> array) {
        int position = startIndex;

        for (ArrayList<Integer> row : array) {
            position = findFinalPosition2(row, position);
        }

        return position;
    }

    // 각 참가자의 최종 결과 구하기 3
    private static int findFinalPosition2(ArrayList<Integer> row, int position){
        if (position > 0 && row.get(position - 1) == 1) {
            position--;
            return position;
        }
        if (position < row.size() && row.get(position) == 1) {
            position++;
            return position;
        }
        return position;
    }
}
