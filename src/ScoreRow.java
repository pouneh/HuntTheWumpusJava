public class ScoreRow implements Comparable<ScoreRow>{
    private String name;
    private int score;
    private String caveName;
    private int turns;
    private int coins;
    private int arrows;
    private boolean won;
    ScoreRow(String name, int score, String cave, int turns, int coins, int arrows, boolean won){
        this.name = name;
        this.score = score;
        this.caveName = cave;
        this.turns = turns;
        this.coins = coins;
        this.arrows = arrows;
        this.won = won;
    }
    @Override
    public int compareTo(ScoreRow b){
        return Integer.compare(b.score,this.score);
    }

    public String getName(){ return name;}
    public int getScore() {return score;}
    public String getCaveName() {return caveName;}
    public int getTurnCount() {return turns;}
    public int getCoins() {return coins;}
    public int getArrowCount(){return arrows;}
    public boolean getWinStatus(){return won;}
}