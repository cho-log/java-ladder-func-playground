package model;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> inputs, int countOfPerson) {
        if (inputs.size() != countOfPerson) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야 합니다.");
        }
        this.prizes = inputs.stream()
                .map(Prize::new)
                .toList();
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getPrize)
                .toList();
    }

}
