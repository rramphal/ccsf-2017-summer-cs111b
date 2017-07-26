import java.awt.*;

public class MyCircle extends Canvas
{
    public void paint (Graphics g)
    {
        int circleSize = 100;
        int x = (getWidth()  / 2) - (circleSize / 2);
        int y = (getHeight() / 2) - (circleSize / 2);
        g.fillOval(x, y, circleSize, circleSize);
    }
}
