/**
 * [DESCRIPTION]
 *
 * @name    DrawCircles (Extra Credit 02)
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.07.26
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DrawCircles" width="0" height="0">
//     <param name="shape" value="square">
// </applet>

public class DrawCircles extends Applet implements ActionListener
{
    /**
     * The current resolution of the target screen
     */
    private Dimension screenSize;

    /**
     * The desired background color
     */
    private final Color BACKGROUND_COLOR = Color.WHITE;

    /**
     * The minimum size (in pixels) of any shape generated
     */
    private final int MIN_SIZE = 20;

    /**
     * The maximum size (in pixels) of any shape generated
     */
    private final int MAX_SIZE = 100;

    Button addButton;
    Button clearButton;

    /**
     * This method returns a random integer between the provided lower limit
     * and upper limit.
     *
     * @param  a   An int representing the lower limit
     * @param  b   An int representing the upper limit
     * @return int A random number between the two limits
     */
    private int rand (int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }

    /**
     * This method returns a randomly-generated Color.
     *
     * @return Color A random color
     */
    private Color getRandomColor ()
    {
        return (new Color(rand(0, 255), rand(0, 255), rand(0, 255)));
    }

    /**
     * This method clears the screen by setting the foreground to the
     * background color. Instead of using the main Graphics instance used in the
     * rest of the applet, this method generates a new instance and disposes
     * of it at the end to enable more flexible reusability.
     */
    private void clearScreen ()
    {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setColor(getForeground());
        g.dispose();
    }

    /**
     * This method sets the applet's size to the size of the target screen.
     */
    private void setToScreenSize ()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        setSize(screenSize);
    }

    /**
     * This is the `init` lifecycle method of the applet. It is executed once
     * on applet instantiation. It sets the applet size to the screen size and
     * sets the background color.
     */
    public void init ()
    {
        setToScreenSize();
        setBackground(BACKGROUND_COLOR);

        addButton = new Button("Add Shape");
        clearButton = new Button("Clear Screen");

        add(addButton);
        add(clearButton);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void actionPerformed (ActionEvent event)
    {
        Graphics g = getGraphics();

        if (event.getSource() == addButton)
        {
            paint(g);
        }
        else if (event.getSource() == clearButton)
        {
            clearScreen();
        }

        g.dispose();
    }

    /**
     * This is the `update` lifecycle method of the applet. It overwrites the
     * default `update` method to only repain the screen WITHOUT clearing the
     * screen.
     *
     * @param graphics An instance of the Graphics class
     */
    public void update (Graphics graphics)
    {
        paint(graphics);
    }

    /**
     * This method draws a circle at the provided X and Y location.
     *
     * @param graphics An instance of the Graphics class
     * @param startX   The X integer value of the location to draw the circle
     * @param startY   The Y integer value of the location to draw the circle
     */
    private void drawCircle (Graphics graphics, int startX, int startY)
    {
        int diameter = rand(MIN_SIZE, MAX_SIZE);
        graphics.fillOval(startX, startY, diameter, diameter);
    }

    /**
     * This method draws a square at the provided X and Y location.
     *
     * @param graphics An instance of the Graphics class
     * @param startX   The X integer value of the location to draw the square
     * @param startY   The Y integer value of the location to draw the square
     */
    private void drawSquare (Graphics graphics, int startX, int startY)
    {
        int dimension = rand(MIN_SIZE, MAX_SIZE);
        graphics.fillRect(startX, startY, dimension, dimension);
    }

    /**
     * This method draws a rectangle at the provided X and Y location.
     *
     * @param graphics An instance of the Graphics class
     * @param startX   The X integer value of the location to draw the rectangle
     * @param startY   The Y integer value of the location to draw the rectangle
     */
    private void drawRectangle (Graphics graphics, int startX, int startY)
    {
        int width  = rand(MIN_SIZE, MAX_SIZE);
        int height = rand(MIN_SIZE, MAX_SIZE);
        graphics.fillRect(startX, startY, width, height);
    }

    /**
     * This method draws a line at the provided X and Y location.
     *
     * @param graphics An instance of the Graphics class
     * @param startX   The X integer value of the location to draw the line
     * @param startY   The Y integer value of the location to draw the line
     */
    private void drawLine (Graphics graphics, int startX, int startY)
    {
        int endX = rand(0, screenSize.width);
        int endY = rand(0, screenSize.height);
        graphics.drawLine(startX, startY, endX, endY);
    }

    /**
     * This is the `paint` lifecycle method of the applet. It generates random
     * shapes of random color, location, and sizes and paints them to the
     * screen with a set delay in between each render. Once the number of shapes
     * on the screen has hit the maximum limit, the screen is cleared and
     * the counter is reset to start afresh.
     */
    public void paint (Graphics graphics)
    {
        int startX = rand(0, screenSize.width);
        int startY = rand(0, screenSize.height);

        Color color = getRandomColor();
        graphics.setColor(color);

        String shape = getParameter("shape");
        if (shape == null) shape = "circle";
        switch (shape)
        {
            case "circle":
                drawCircle(graphics, startX, startY);
                break;
            case "square":
                drawSquare(graphics, startX, startY);
                break;
            case "rectangle":
                drawRectangle(graphics, startX, startY);
                break;
            case "line":
                drawLine(graphics, startX, startY);
                break;
            default:
                drawCircle(graphics, startX, startY);
                break;
        }
    }
}
