import java.awt.*;
import java.applet.*;

public class DemoSound extends Applet
{
    AudioClip ac;
    String filename;

    public void init ()
    {
        filename = getParameter("filename");
        AudioClip ac = new AudioClip(getDocumentBase(), filename);
        ac.loop(); // prepares system to play audio
        add(new Label("Playing " + filename));

        // automatically calls start
    }

    public void start ()
    {
        ac.play();
    }

    public void stop ()
    {
        ac.stop();
    }
}
