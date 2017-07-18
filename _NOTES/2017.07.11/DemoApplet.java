// > javac DemoApplet.java && appletViewer DemoApplet.java

import java.awt.*;
import java.applet.*;

// <applet code="DemoApplet.java" height="300" width="400"></applet>

@SuppressWarnings("serial")
public class DemoApplet extends Applet
{
    public static int rand(int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }

    public Color rgb (int red, int green, int blue)
    {
        return (new Color(red, green, blue));
    }

    public Color getRandomColor ()
    {
        return (new Color(rand(0, 255), rand(0, 255), rand(0, 255)));
    }

    public void init() {
        // Color provides 16 colors
        setForeground(Color.CYAN);
        setBackground(rgb(0, 0, 255));
    }

    public void paint (Graphics g)
    {
        // [Graphics].drawString(String string, int x, int y)
        // (0, 0) is the top-left-most pixel
        // no negative values
        // default color: white/gray background, black foreground
        g.drawString("Hello Applet", 20, 30);

        g.setColor(Color.RED);
        g.drawLine(20, 40, 180, 200);
        g.setColor(Color.MAGENTA);
        g.drawLine(100, 120, 75, 90);
        g.setColor(Color.GRAY);
        g.drawLine(50, 80, 200, 210);

        g.drawRect(50, 60, 100, 80);
        g.fillRect(75, 89, 50, 50);

        // g.setColor only works on foreground colors, not background colors
    }
}
