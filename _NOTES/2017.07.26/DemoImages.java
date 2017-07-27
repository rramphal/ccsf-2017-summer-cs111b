import java.awt.*;
import java.applet.*;

public class DemoImages extends Applet
{
    Image img;

    public void init()
    {
        // getDocumentBase() // the URL of the document in which this applet is embedded (HTML file)
        // getCodeBase()     // the URL of the directory which contains this applet (Class file)
        img = getImage(getDocumentBase(), "cat.jpg");
    }

    public void paint (Graphics graphics)
    {
        graphics.drawImage(img, 0, 0, this);
        // graphics.drawImge(Image img, int x, int y, int w, int h, this)
        // graphics.drawImge(Image img, int x, int y, int w, int h, Color background, this)
    }
}
