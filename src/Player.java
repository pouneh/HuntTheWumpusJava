import java.util.Optional;

public class Player extends Entity{
    private int coinCount = 0;
    private int arrowCount = 0;
    private int turnCount = 0;
    private boolean wonGame = false;

    Player(){
        super();
    }

    public void  EndTurn(){
        turnCount ++;
    }

    public void WinGame(){
        EndTurn();
        wonGame = true;
    }
    public int FoundCoin(Optional<Integer> countFound){
        Integer count = countFound.isPresent() ? countFound.get() : 1;
        coinCount += count;
        return coinCount;
    }

    public int SpendsCoin(Optional<Integer> countSpent){
        Integer count = countSpent.isPresent() ? countSpent.get() : 1;
        coinCount -= count;
        return coinCount;
    }

    public int ObtainedArrow(Optional<Integer> countEarned){
        Integer count = countEarned.isPresent() ? countEarned.get() : 1;
        arrowCount += count;
        return arrowCount;
    }

    public int ShootsArrow(Optional<Integer> countShot){
        Integer count = countShot.isPresent() ? countShot.get() : 1;
        arrowCount -= count;
        return arrowCount;
    }

    public int GetCurrentScore(){
        return (100 - turnCount + coinCount + 5*arrowCount + (wonGame ? 50 : 0));
    }
}
