import java.awt.*;

public class DemoFrame extends Frame
{
    public DemoFrame()
    {
        setSize(400, 500);
        setTitle("My Frame");
        add(new Label("Hello Frame!"));
        setVisible(true);
    }

    public static void main (String ... args)
    {
        new DemoFrame();
    }
}
