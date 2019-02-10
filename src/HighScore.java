import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class HighScore {
        private static HighScore instance;
        private static String filePath = Paths.get(Main.ResourceDirectory, "scores.csv").toString();
        private static ArrayList<ScoreRow> scores = new ArrayList<ScoreRow>();

        public static ArrayList<ScoreRow> Init()
        {
            if (instance == null){
                instance = new HighScore();
            }
            return instance.scores;
        }

        HighScore(){
            Stream<String> stream = Stream.empty();
            try { stream =  Files.lines(Paths.get(filePath));}
            catch(Exception e){ System.out.println(e.getMessage());}

            for(String row : stream.toArray(String[]::new)){
                StringTokenizer st = new StringTokenizer(row, ",", false);
                ScoreRow next = new ScoreRow(st.nextToken(),Integer.parseInt(st.nextToken()), st.nextToken());
                scores.add(next);
            }
            Collections.sort(scores);
        }

        public static void UpdateScore(ScoreRow newScore){
            scores.add(newScore);
            Collections.sort(scores);
            Collections.reverse(scores);
            while(scores.size() >10){
                scores.remove(0);
            }
        }

        public static void SaveScores(){
            try {
                PrintWriter pw = new PrintWriter(filePath);
                for(ScoreRow s : scores){
                    pw.println(new String(new StringBuilder()
                            .append(s.getName()).append(',')
                            .append(s.getScore()).append(',')
                            .append(s.getCaveName())));
                }
                pw.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Cannot save scores");
            }
        }
}
