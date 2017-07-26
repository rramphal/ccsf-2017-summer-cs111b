import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DemoCircle" height="500" width="500"></applet>

public class DemoCircle extends Applet implements ActionListener
{
    MyCircle mc = new MyCircle();

    Panel p = new Panel();

    Button b1 = new Button("Blue");
    Button b2 = new Button("Red");
    Button b3 = new Button("Yellow");

    public void init ()
    {
        mc.setForeground(Color.BLUE);
        setLayout(new GridLayout(2, 1));

        p.setLayout(new GridLayout(1,3));

        add(mc);
        add(p);

        p.add(b1);
        p.add(b2);
        p.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setVisible(true); // just to ensure everything shows
    }

    public void actionPerformed (ActionEvent event)
    {
        if (event.getSource() == b1)
        {
            mc.setForeground(Color.BLUE);
        }
        else if (event.getSource() == b2)
        {
            mc.setForeground(Color.RED);
        }
        else if (event.getSource() == b3)
        {
            mc.setForeground(Color.YELLOW);
        }

        mc.repaint();
    }
}
