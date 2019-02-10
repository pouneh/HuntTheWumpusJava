import java.util.Optional;

public class Player extends Entity{
    private int coinCount = 0;
    private int arrowCount = 0;
    Player(){
        super();
    }

    private int FoundCoin(Optional<Integer> countFound){
        Integer count = countFound.isPresent() ? countFound.get() : 1;
        coinCount += count;
        return coinCount;
    }

    private int SpendsCoin(Optional<Integer> countSpent){
        Integer count = countSpent.isPresent() ? countSpent.get() : 1;
        coinCount -= count;
        return coinCount;
    }

    private int ObtainedArrow(Optional<Integer> countEarned){
        Integer count = countEarned.isPresent() ? countEarned.get() : 1;
        arrowCount += count;
        return arrowCount;
    }

    private int ShootsArrow(Optional<Integer> countShot){
        Integer count = countShot.isPresent() ? countShot.get() : 1;
        arrowCount -= count;
        return arrowCount;
    }
}
