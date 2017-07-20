import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DemoGridLayout" height="200" width="500"></applet>

public class DemoGridLayout extends Applet
{
    public void init ()
    {
        setLayout(new GridLayout(4, 4));
        setFont(new Font("Sans Serif", Font.BOLD, 24));

        // 1-16
        // for (int i = 1; i <= 16; i++)
        // {
        //     add(new Button("" + i));
        // }

        // 1-15+blank
        // for (int i = 0; i < 4; i++)
        // {
        //     for (int j = 0; j < 4; j++)
        //     {
        //         int k = 4 * i + j;
        //
        //         if (k > 0) add(new Button("" + k));
        //     }
        // }

        // column 1-5
        // setLayout(new GridLayout(5, 1));
        // for (int i = 1; i <= 5; i++)
        // {
        //     add(new Button("" + i));
        // }

        // row 1-5
        // setLayout(new GridLayout(1, 4));
        // for (int i = 1; i <= 4; i++)
        // {
        //     add(new Button("" + i));
        // }
    }
}
