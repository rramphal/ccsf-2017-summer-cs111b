import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet code="Dual" width="400" height="300"></applet>

public class Dual extends Applet // or Frame
{
    public void init ()
    {
        Label l = new Label("I am an applet.");
        add(l);
    }

    public Dual ()
    {
        // setTitle("My Title");
        setSize(400, 300);
        Label l = new Label("I am in a Frame.");
        add (l);
        setVisible(true);
    }

    public static void main (String ... args)
    {
        new Dual();
    }
}
