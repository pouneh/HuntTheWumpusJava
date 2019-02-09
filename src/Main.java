//This class will function as the GameController of the project.
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Component.*;
import java.awt.event.*;

public class Main {
    public static int SplashScreenDelay = 2;

    public static void main(String[] args) {
        UI.Create();
        UI.instance.ShowSplashScreen();
        //UI.instance.ShowMainMenu();
    }
}
