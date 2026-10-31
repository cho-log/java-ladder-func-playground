package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//재료 3개 -> 이름들(Names), 상품들(Prizes), 사다리타고 내려간 최종위치들(LadderResult) -> PlayerPrize를 만들어서 PlayerPrizes에 담는다.
//PlayerPrizes는 PlayerPrize들을 담는 클래스
//PlayerPrize는 한명의 참여자와 그 참여자가 얻은 상품을 담는 클래스

public class PlayerPrizes {

    private final List<PlayerPrize> playerPrizes;

    private PlayerPrizes(List<PlayerPrize> playerPrizes) {
        this.playerPrizes = playerPrizes;
    }

    public static PlayerPrizes of(Names names, Prizes prizes, LadderResult result) {
        List<Position> arrivals = result.arrivals(); //result에서 사다리를 타고 내려간 최종 위치들을 가져온다.
        List<PlayerPrize> playerPrizes = new ArrayList<>();//PlayerPrize들을 담는 리스트를 생성한다.

        for (int index = 0; index < arrivals.size();
             index++) { //사다리를 타고 내려간 최종 위치들의 개수만큼 반복하면서 PlayerPrize를 생성하여 리스트에 추가한다.
            Name name = names.names().get(index);//names에서 참여자 이름들을 가져온다.
            Prize prize = prizes.prizes().get(arrivals.get(index).value());//prizes에서 사다리를 타고 내려간 최종 위치에 해당하는 상품을 가져온다.
            playerPrizes.add(new PlayerPrize(name, prize));//PlayerPrize를 생성하여 리스트에 추가한다.
        }
        return new PlayerPrizes(playerPrizes);
    }

    public PlayerPrize find(String name) {//
        return playerPrizes.stream()
                .filter(playerPrize -> playerPrize.name().value().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 이름입니다.")); //해당 이름을 가진 PlayerPrize를 찾지 못하면 예외를 던진다.
    }

    public List<PlayerPrize> all() { //all() 메서드는 PlayerPrize들을 담은 리스트를 반환함
        return Collections.unmodifiableList(playerPrizes);
    }
}
