// > javac Fonts.java && appletViewer Fonts.java

import java.awt.*;
import java.applet.*;

// <applet code="Fonts.java" height="300" width="400"></applet>

@SuppressWarnings("serial")
public class Fonts extends Applet
{
    public static int rand(int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }

    public Color getRandomColor ()
    {
        return (new Color(rand(0, 255), rand(0, 255), rand(0, 255)));
    }

    public void paint (Graphics g)
    {
        g.setColor(getRandomColor());
        Font f = new Font("Serif", Font.PLAIN, 20);
        setFont(f);
        g.drawString("Hello Applet", 20, 30);
    }
}
