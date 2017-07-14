// > javac RandomCircles.java && appletViewer RandomCircles.java

import java.awt.*;
import java.applet.*;

// <applet code="RandomCircles.java" height="300" width="400"></applet>

@SuppressWarnings("serial")
public class RandomCircles extends Applet
{
    int count         = 0;
    int diameter      = 20;
    int delayDuration = 300;
    int maxCircles    = 20;

    public void delay (int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {}
    }

    public int rand (int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }

    public void clearScreen ()
    {
        Graphics g = getGraphics(); // is created in the heap (and won't be cleaned up by garbage collection)
        g.setColor(getBackground());
        g.fillRect(0, 0, getSize().width, getSize().height); // `getSize()` returns a `Dimension` object
        g.setColor(getForeground());
        g.dispose(); // this explicitly removes it from the heap
    }

    // overwrite `update` method to NOT clear the screen
    public void update (Graphics g)
    {
        paint(g);
    }

    public void paint (Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(rand(0, getSize().width - diameter), rand(0, getSize().height - diameter), diameter, diameter);
        delay(delayDuration);
        repaint();
        count++;
        if (count == maxCircles)
        {
            clearScreen();
            count = 0;
        }
    }
}
