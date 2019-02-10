//This class will function as the GameController of the project.
import java.nio.file.Paths;

public class Main {
    public static int SplashScreenDelay = 2;
    public static final String WorkingDirectory = Paths.get(System.getProperty("user.dir")).toString();
    public static final String ResourceDirectory = Paths.get(WorkingDirectory, "resources").toString();

    public static void main(String[] args) {
        GameEntities.Init();
        UI.Create();
        HighScore.Init();

        //UI.instance.ShowSplashScreen();
        //UI.instance.ShowMainMenu();


        HighScore.SaveScores();
        System.exit(0);
    }
}