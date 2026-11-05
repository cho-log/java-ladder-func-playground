package model;

import java.util.Iterator;
import java.util.List;

public class Prizes implements Iterable<Prize> {
    private final List<Prize> prizes;

    public Prizes(List<String> inputs, int countOfPerson) {
        if (inputs.size() != countOfPerson) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야 합니다.");
        }
        this.prizes = inputs.stream()
                .map(Prize::new)
                .toList();
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    @Override
    public Iterator<Prize> iterator() {
        return prizes.iterator();
    }
}
