import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;


public class UI{
    public static Dimension screenSize;
    public static UI instance = null;
    public static final Font HEADERFONT = new Font("Sanserif", Font.PLAIN, 40);
    public static final Font BODYFONT = new Font("Sanserif",Font.PLAIN,25);

    private JFrame menuFrame = new JFrame();
    private JFrame aboutFrame = new JFrame();

    private class HighScore{
        private JFrame highscoreFrame = new JFrame();

        HighScore(){
            //Load in highscore data from file
                //close file
            //create panel for highscore display
        }
    }

    public static void Create(){
        //Good place to do the lookandfeel if i decide to go with it
        instance = new UI();
    }

    private UI(){
         screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         MainMenu();
         About();
         HighScore();
    }

    public void ShowSplashScreen()
    {
        JFrame frame = new JFrame("SplashScreen");
        frame.setUndecorated(true);

        JLabel imgLabel = new JLabel(new ImageIcon("C:/Users/spark/Desktop/Fiddle/resources/g761.png"));

        frame.add(imgLabel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(Main.SplashScreenDelay);
        }
        catch(Exception e){}
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public void ShowMainMenu(){
        menuFrame.setVisible(true);
    }

    public void ShowHighScore(){
        // #TODO
        return;
    }

    public void ShowHowTo(){
        // #TODO
        return;
    }

    public void StartGame(){

    }

    private void MainMenu()
    {
        JPanel menuPanel = new JPanel();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0,0);
        menuFrame.setLayout(fl);
        menuFrame.setUndecorated(true);

        menuPanel.setBackground(Color.white);
        menuPanel.setBorder(null);

        MenuButton title    = new MenuButton("Main Menu");
        MenuButton play     = new MenuButton("Play Game");
        MenuButton highscore= new MenuButton("High Scores");
        MenuButton howTo    = new MenuButton("How To Play");
        MenuButton about    = new MenuButton("About");
        MenuButton quit     = new MenuButton("Quit");


        /title.select
        //play.addActionListener(this);
        //howTo.addActionListener(this);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                menuFrame.setVisible(false);
                aboutFrame.setVisible(true);
            }});;
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                menuFrame.dispatchEvent(new WindowEvent( menuFrame, WindowEvent.WINDOW_CLOSING));
            }});

        menuPanel.add(title);
        menuPanel.add(play);
        menuPanel.add(highscore);
        menuPanel.add(howTo);
        menuPanel.add(about);
        menuPanel.add(quit);

        menuPanel.setPreferredSize(new Dimension(title.getPreferredSize().width, title.getPreferredSize().height*6 + 36));
        menuFrame.add(menuPanel);

        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //REMOVE THIS
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
    }

    private void About()
    {
        //Details about developer and purpose of the project
        String title        = "Hunt the Wumpus\n\n";
        String data         = "This software was created as a proof of concept for the annual Hunt the Wumpus " +
                              "project conducted at various high schools in the PS area\n\n";
        String developer    = "(c) Pouneh Aghababazadeh 2019";

        JPanel aboutPanel = new JPanel();
        aboutFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        aboutFrame.setUndecorated(true);

        JTextPane tp = new JTextPane();
        tp.setBackground(Color.WHITE);
        MenuButton back = new MenuButton("Back");
        aboutPanel.setPreferredSize(new Dimension(back.getPreferredSize().width, back.getPreferredSize().height*3+10));

        //aboutFrame.setPreferredSize();
        tp.setPreferredSize(new Dimension(back.getPreferredSize().width, back.getPreferredSize().height*2));
        tp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        tp.setBackground(Color.BLACK);
        tp.setForeground(Color.WHITE);
        addHeader(tp, title);
        addBody(tp,data);
        addBody(tp,developer);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aboutFrame.setVisible(false);
                menuFrame.setVisible(true);
            }});

        tp.setLayout(new BoxLayout(tp, BoxLayout.Y_AXIS));
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));

        aboutPanel.add(tp);
        aboutPanel.add(back);
        aboutFrame.add(aboutPanel);
        aboutFrame.pack();
        aboutFrame.setLocationRelativeTo(null);

    }

    private void HighScore()
    {

    }

    private void addHeader(@NotNull JTextPane pane, String text) {
        StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Header Style", null);
        StyleConstants.setFontSize(style,HEADERFONT.getSize());
        try {
            doc.insertString(doc.getLength(), text, style);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBody(@NotNull JTextPane pane, String text) {
        StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Header Style", null);
        StyleConstants.setFontSize(style,BODYFONT.getSize());
        try {
            doc.insertString(doc.getLength(), text, style);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
