// > javac DrawPolygon.java && appletViewer DrawPolygon.java

import java.awt.*;
import java.applet.*;

// <applet code="DrawPolygon.java" width="500" height="400">
//     <param name="x" value="10">
//     <param name="y" value="10">
// </applet>

@SuppressWarnings("serial")
public class DrawPolygon extends Applet
{
    int x;
    int y;

    public void init ()
    {
        x = Integer.parseInt(getParameter("x"));
        y = Integer.parseInt(getParameter("y"));
    }

    public void paint(Graphics g)
    {
        // g.drawPolygon(int[] x, int[] y, int numSides);
        // g.fillPolygon(int[] x, int[] y, int numSides);
        int[] x = { 30, 200, 300, 200, 30 };
        int[] y = { 30,  30, 200, 200, 30 };
        g.drawPolygon(x, y, x.length);
    }
}
