/**
 * This applet generates a screensaver using Java's AWT Graphics API.
 * The screensaver generates a given shape in random sizes, colors, and
 * locations set against a white background. The screensaver's height and width
 * is a
 * The shape is defined as a parameter
 * passed to the applet. Possible shapes include:
 *     - `circle`
 *     - `square`
 *     - `rectangle`
 *     - `line`
 *
 * @name    ScreenSaver (Homework Assignment 05)
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.07.17
 * @version 1.0
 */

import java.awt.*;
import java.applet.*;

// <applet code="ScreenSaver.java" width="0" height="0">
//     <param name="shape" value="circle">
// </applet>

@SuppressWarnings("serial")
public class ScreenSaver extends Applet
{
    int count         = 0;
    int delayDuration = 500;
    int maxCircles    = 500;
    int minSize       = 20;
    int maxSize       = 100;

    Dimension screenSize;

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

    public Color getRandomColor ()
    {
        return (new Color(rand(0, 255), rand(0, 255), rand(0, 255)));
    }

    public void clearScreen ()
    {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setColor(getForeground());
        g.dispose();
    }

    public void setToScreenSize ()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        setSize(screenSize);
    }

    public void init ()
    {
        setToScreenSize();
    }

    // overwrite `update` method to NOT clear the screen
    public void update (Graphics g)
    {
        paint(g);
    }

    public void paint (Graphics g)
    {
        String shape = getParameter("shape");

        Color randomColor = getRandomColor();

        int randomX = rand(0, screenSize.width);
        int randomY = rand(0, screenSize.height);

        g.setColor(randomColor);

        if (shape.equals("circle"))
        {
            int randomDiameter = rand(minSize, maxSize);
            g.fillOval(randomX, randomY, randomDiameter, randomDiameter);
        }
        else if (shape.equals("square")) {
            int randomDimension = rand(minSize, maxSize);
            g.fillRect(randomX, randomY, randomDimension, randomDimension);
        }
        else if (shape.equals("rectangle")) {
            int randomWidth = rand(minSize, maxSize);
            int randomHeight = rand(minSize, maxSize);
            g.fillRect(randomX, randomY, randomWidth, randomHeight);
        }
        else if (shape.equals("line")) {
            int randomPointX = rand(minSize, maxSize);
            int randomPointY = rand(minSize, maxSize);
            g.drawLine(randomX, randomY, randomPointX, randomPointY);
        }

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
