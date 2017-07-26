import java.awt.*;
import java.awt.event.*;

public class SomeLines extends Frame
{
    public static void closeFrame (Frame f)
    {
        // this is an anonymous inner class
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }

    public SomeLines()
    {
        setLayout(new GridLayout(2, 1, 10, 10));
        setSize(400, 500);
        setTitle("My Frame");

        setFont(new Font("Serif", Font.BOLD, 18));
        setForeground(new Color(180, 50, 200)); // magenta
        setBackground(new Color(40, 170, 160)); // cyan

        add(new Label("I like Frames more"));
        add(new Label("than Applets"));

        setVisible(true);
    }

    public static void main (String ... args)
    {
        SomeLines sl = new SomeLines();
        closeFrame(sl); // allows 'x' to close
    }

    public void init()
    {
        int x;
    }
}
