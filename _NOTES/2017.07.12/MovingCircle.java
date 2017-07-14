// > javac DemoApplet.java && appletViewer DemoApplet.java

import java.awt.*;
import java.applet.*;

// <applet code="MovingCircle.java" height="300" width="400"></applet>

@SuppressWarnings("serial")
public class MovingCircle extends Applet
{
    int x;
    int direction = 1;

    public void init()
    {
        x = 10;
    }

    public void sleep (int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {}
    }

    public void paint (Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(x, 150, 20, 20);
        x += 10 * direction;
        if (x > 370) direction = -1;
        if (x < 10)  direction =  1;
        // repaint (int delay) depends on Browser's delay mechanism
        // and is therefore ureliable.
        // Instead, we should just repaint just the section that has changed
        //     repaint (int x, int y, int w, int h)
        // with our own delay function.
        sleep(100);
        repaint(0, 0, 400, 300);
    }
}
