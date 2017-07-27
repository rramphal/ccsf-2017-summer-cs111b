/**
 * This applet generates shapes using Java's AWT Graphics API.
 * It allows the user to click a button to generate a given shape in random
 * sizes, colors, and locations set against a white background.
 * The applet's height and width is set to the screen's height and width.
 * The shape is defined as a parameter passed to the applet.
 * Possible shapes include: `circle`, `square`, `rectangle`, and `line`.
 * If the user does not pass a `shape` param or if param passed does not match
 * one of the possible shapes, the applet defaults to drawing circles.
 *
 * @name    DrawShapes (Extra Credit 02)
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.07.27
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DrawShapes" width="0" height="0">
//     <param name="shape" value="circle">
// </applet>

public class DrawShapes extends Applet implements ActionListener
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

    /**
     * The size of the margin of the generating area
     */
    private final int MARGIN = 50;

    /**
     * The X lower limit for any shape generated
     */
    private int minX;

    /**
     * The X upper limit for any shape generated
     */
    private int maxX;

    /**
     * The Y lower limit for any shape generated
     */
    private int minY;

    /**
     * The Y upper limit for any shape generated
     */
    private int maxY;

    /**
     * The button to add a shape
     */
    Button addButton;

    /**
     * The button to clear the screen
     */
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
     * This method defines the boundaries of the generation area.
     */
    private void defineBoundaries ()
    {
        minX = MARGIN;
        maxX = screenSize.width - MARGIN;
        minY = MARGIN;
        maxY = screenSize.height - (MARGIN * 2);
    }

    /**
     * This is the `init` lifecycle method of the applet. It is executed once
     * on applet instantiation. It sets the applet size to the screen size,
     * defines the boundaries of the generation area, and sets the background
     * color. It also adds two buttons to the applet and assigns listeners.
     */
    public void init ()
    {
        setToScreenSize();
        defineBoundaries();

        setBackground(BACKGROUND_COLOR);

        addButton = new Button("Add Shape");
        clearButton = new Button("Clear Screen");

        add(addButton);
        add(clearButton);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    /**
     * This is the `actionPerformed` handler for the two buttons. They call
     * the correct respective actions depending on which button was pressed.
     *
     * @param event The ActionEvent fired by the buttons
     */
    public void actionPerformed (ActionEvent event)
    {
        if (event.getSource() == addButton)
        {
            Graphics g = getGraphics();
            paint(g);
            g.dispose();
        }
        else if (event.getSource() == clearButton)
        {
            clearScreen();
        }
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
     * This method draws a circle.
     *
     * @param graphics An instance of the Graphics class
     */
    private void drawCircle (Graphics graphics)
    {
        int startX   = rand(minX, maxX);
        int startY   = rand(minY, maxY);
        int diameter = rand(MIN_SIZE, MAX_SIZE);

        if ((startX + diameter) >= maxX) startX = maxX - diameter;
        if ((startY + diameter) >= maxY) startY = maxY - diameter;

        graphics.fillOval(startX, startY, diameter, diameter);
    }

    /**
     * This method draws a square.
     *
     * @param graphics An instance of the Graphics class
     */
    private void drawSquare (Graphics graphics)
    {
        int startX    = rand(minX, maxX);
        int startY    = rand(minY, maxY);
        int dimension = rand(MIN_SIZE, MAX_SIZE);

        if ((startX + dimension) >= maxX) startX = maxX - dimension;
        if ((startY + dimension) >= maxY) startY = maxY - dimension;

        graphics.fillRect(startX, startY, dimension, dimension);
    }

    /**
     * This method draws a rectangle.
     *
     * @param graphics An instance of the Graphics class
     */
    private void drawRectangle (Graphics graphics)
    {
        int startX = rand(minX, maxX);
        int startY = rand(minY, maxY);
        int width  = rand(MIN_SIZE, MAX_SIZE);
        int height = rand(MIN_SIZE, MAX_SIZE);

        if ((startX + width)  >= maxX) startX = maxX - width;
        if ((startY + height) >= maxY) startY = maxY - height;

        graphics.fillRect(startX, startY, width, height);
    }

    /**
     * This method draws a line.
     *
     * @param graphics An instance of the Graphics class
     */
    private void drawLine (Graphics graphics)
    {
        int startX = rand(minX, maxX);
        int startY = rand(minY, maxY);
        int endX   = rand(minX, maxX);
        int endY   = rand(minY, maxY);

        graphics.drawLine(startX, startY, endX, endY);
    }

    /**
     * This is the `paint` lifecycle method of the applet. It generates random
     * shapes of random color, location, and sizes and paints them to the
     * screen.
     */
    public void paint (Graphics graphics)
    {
        Color color = getRandomColor();
        graphics.setColor(color);

        String shape = getParameter("shape");
        if (shape == null) shape = "circle";
        switch (shape)
        {
            case "circle":
                drawCircle(graphics);
                break;
            case "square":
                drawSquare(graphics);
                break;
            case "rectangle":
                drawRectangle(graphics);
                break;
            case "line":
                drawLine(graphics);
                break;
            default:
                drawCircle(graphics);
                break;
        }
    }
}
