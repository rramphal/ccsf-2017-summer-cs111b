// > javac Params.java && appletViewer Params.java

import java.awt.*;
import java.applet.*;

// <applet code="Params.java" height="300" width="400">
//     <param name="age" value="92">
//     <param name="car" value="BMW">
// </applet>

@SuppressWarnings("serial")
public class Params extends Applet
{
    int age;

    public void init ()
    {
        String ageParam = getParameter("age");
        String carParam = getParameter("car");

        age = Integer.parseInt(ageParam);
    }

    public void paint(Graphics g)
    {
        g.drawString("" + age, 20, 20);
    }
}
