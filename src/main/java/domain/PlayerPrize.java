package domain;
// neo   → 꽝
//  brown → 3000
//  brie  → 꽝
//  tommy → 5000
//이 한줄을 저장하는게 PlayerPrize

public class PlayerPrize {
    private final Name name;
    private final Prize prize;

    public PlayerPrize(Name name, Prize prize) {
        this.name = name;
        this.prize = prize;
    }

    public Name name() {
        return name;
    }

    public Prize prize() {
        return prize;
    }


}

