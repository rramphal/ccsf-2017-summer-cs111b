import java.awt.*;
import java.applet.*;

// <applet code="Labels" height="500" width="500"></applet>

public class Labels extends Applet
{
    public void init ()
    {
        Label label1 = new Label("Hello");
        Label label2 = new Label("Alex");
        Label label3 = new Label("David");

        label1.setFont(new Font("Herculanum", Font.PLAIN, 32));
        label2.setFont(new Font("Papyrus", Font.PLAIN, 28));
        label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

        add(label2); // `add` comes from the `Container` class
        add(label1);
        add(label3);

        // Will print "Alex Hello David" according to the order in which the
        // labels were added to the container.

        Label label4 = new Label();
        label4.setText("Cathy");
        add(label4);
    }

    public void paint (Graphics g)
    {
        g.drawString("THIS IS A STRING", 50, 30);
        // this will be printed fixed BEHIND the labels
    }
}
