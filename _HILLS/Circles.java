// Author: Abbas Moghtanei

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Circles extends Frame
{
/*****************************Circles cunstructor*****************************/     
    int r = 5, v = 1;
    public Circles()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((d.getWidth() - getWidth())/2);
        int y = (int) ((d.getHeight() - getHeight())/2);

        setSize(600, 600);
        setBackground(Color.black);
        setForeground(Color.pink);
        setTitle("Circles screen saver");
        setLocation(x, y);            // to center the frame 
        setLocationRelativeTo(null);  // to center the frame
        setVisible(true);
    }
/************************************paint()*********************************/
    public void paint(Graphics g)
    {
        Color c = new Color(rand(0,255), rand(0,255), rand(0,255));
        g.setColor(c);
        g.drawOval(30, 50, r, r);
        if ( (r += 3*v) > 540 ) v = v*(-1);
        if ( r <= 5 )           v = v*(-1);
        repaint(40);
    }
/************************************update()********************************/
    public void update(Graphics g)   // to eliminate clearing the screen by
    {                                // the default update.
        paint(g);
    }
/**********************************closeFrame()******************************/
    public static void closeFrame(Frame f)
    {
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
/*************************************rand()*********************************/
    public int rand(int a, int b)
    {
        return((int)((b-a+1)*Math.random() + a));
    }
/**************************************main()********************************/     
    public static void main(String s[])
    {
        Circles  C = new Circles();
        closeFrame(C);
    }
}

