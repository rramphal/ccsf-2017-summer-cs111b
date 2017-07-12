import java.awt.*;
import java.applet.*;

// <applet code="DemoApplet" height="300" width="400"></applet>

public class DemoApplet extends Applet
{
    // public void init() {}

    // public void start() {}

    public void paint (Graphics g)
    {
        // [Graphics].drawString(String string, int x, int y)
        // (0, 0) is the top-left-most pixel
        // no negative values
        // default color: white/gray background, black foreground
        g.drawString("Hello Applet", 20, 30);
    }

    // public void stop() {}

    // public void destroy() {}
}
