import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton{
    private Font font = null;
    private static int snap = 10;
    private String t2;

    MenuButton(String title){
        super();
        t2 = title;
        startButton();
    }
    private void startButton(){
        int xdim = ((UI.screenSize.width/3 + snap - 1)/(snap))*(snap);
        int ydim = ((UI.screenSize.height/10 + snap -1 )/(snap))*(snap);
        setPreferredSize(new Dimension(xdim, ydim));
        if (font == null){
            font = UI.HEADERFONT;
        }
        this.setFont(font);
        BoxLayout bl = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(bl);
    }


    @Override
    protected void paintComponent(java.awt.Graphics g)
    {
        FontMetrics metrics = g.getFontMetrics();
        int xoffset = (int)(metrics.getStringBounds(t2, g).getWidth());
        int yoffset = (int)(metrics.getStringBounds(t2, g).getHeight());
        int x = (getWidth() - xoffset)/2;
        int y = getHeight()/2 + yoffset/2;

        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        g.drawString(t2,x,y);
    }

}
