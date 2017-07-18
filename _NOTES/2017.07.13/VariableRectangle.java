// > javac VariableRectangle.java && appletViewer VariableRectangle.java

import java.awt.*;
import java.applet.*;

// <applet code="VariableRectangle.java" width="500" height="400">
//     <param name="width" value="250">
//     <param name="height" value="200">
// </applet>

@SuppressWarnings("serial")
public class VariableRectangle extends Applet
{
    int width;
    int height;

    public void init ()
    {
        String widthParam  = getParameter("width");
        String heightParam = getParameter("height");

        width  = Integer.parseInt(widthParam);
        height = Integer.parseInt(heightParam);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(10, 10, width, height);
    }
}
