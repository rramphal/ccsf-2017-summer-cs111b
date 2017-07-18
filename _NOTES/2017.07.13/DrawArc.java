// > javac DrawArc.java && appletViewer DrawArc.java

import java.awt.*;
import java.applet.*;

// <applet code="DrawArc.java" width="500" height="400">
//     <param name="x" value="10">
//     <param name="y" value="10">
//     <param name="arcWidth" value="80">
//     <param name="arcHeight" value="70">
//     <param name="startAngle" value="0">
//     <param name="sweepAngle" value="145">
// </applet>

@SuppressWarnings("serial")
public class DrawArc extends Applet
{
    int x;
    int y;
    int arcWidth;
    int arcHeight;
    int startAngle;
    int sweepAngle;

    public void init ()
    {
        x          = Integer.parseInt(getParameter("x"));
        y          = Integer.parseInt(getParameter("y"));
        arcWidth   = Integer.parseInt(getParameter("arcWidth"));
        arcHeight  = Integer.parseInt(getParameter("arcHeight"));
        startAngle = Integer.parseInt(getParameter("startAngle"));
        sweepAngle = Integer.parseInt(getParameter("sweepAngle"));
    }

    public void paint(Graphics g)
    {
        // g.drawArc(x, y, arcWidth, arcHeight, startAngle, sweepAngle);
        g.fillArc(x, y, arcWidth, arcHeight, startAngle, sweepAngle);
    }
}
