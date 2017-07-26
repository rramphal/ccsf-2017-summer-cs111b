import java.awt.*;
import java.applet.*;

// <applet code="DemoCanvas" height="500" width="500"></applet>

public class DemoCanvas extends Applet
{
    public void init ()
    {
        Label l = new Label("A circle", Label.CENTER);
        MyCircle mc = new MyCircle();

        l.setFont(new Font("Dialog", Font.BOLD, 18));

        setLayout(new GridLayout(2, 1));

        add(mc);
        add(l);

        setVisible(true); // just to ensure everything shows
    }
}
