public class ScoreRow implements Comparable<ScoreRow>{
    private String name;
    private int score;
    private String caveName;
    ScoreRow(String name, int score, String cave){
        this.name = name;
        this.score = score;
        this.caveName = cave;
    }
    @Override
    public int compareTo(ScoreRow b){
        return Integer.compare(b.score,this.score);
    }

    public String getName(){ return name;}
    public int getScore() {return score;}
    public String getCaveName() {return caveName;}
}