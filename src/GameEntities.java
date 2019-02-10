public class GameEntities {
    private static GameEntities instance;
    private static Player player;
    private Entity wumpus;
    private Entity bat1;
    private Entity bat2;



    public static GameEntities Init(){
        if(instance == null){
            instance = new GameEntities();
        }
        return instance;
    }

    private GameEntities(){
        player = new Player();
        //TODO create Antagonists
        //TODO create Player

    }
}
