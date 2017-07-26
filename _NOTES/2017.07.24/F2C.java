import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="F2C" height="500" width="500"></applet>

// https://www.github.com/brickky/java-notes

public class F2C extends Applet
{
    Panel p1;
    Panel p2;
    Panel p3;

    TextField tf1;
    TextField tf2;

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            double ftemp;
            double ctemp;

            ftemp = Double.parseDouble(tf1.getText());
            ctemp = (5.0 / 9.0) * (ftemp - 32);

            tf2.setText(String.format("%.2f", ctemp));
        }
    }

    public void buildFPanel()
    {
        p1 = new Panel();
        Label msg = new Label("Fahrenheit Temperature: ");
        tf1 = new TextField(10);

        p1.setLayout(new FlowLayout(FlowLayout.RIGHT));

        p1.add(msg);
        p1.add(tf1);
    }

    public void buildCPanel()
    {
        p2 = new Panel();
        Label msg = new Label("Celcius Temperature: ");
        tf2 = new TextField(10);

        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));

        p2.add(msg);
        p2.add(tf2);
    }

    public void buildButtonPanel()
    {
        p3 = new Panel();
        Button b = new Button("Convert");

        // p3.setLayout(new FlowLayout(FlowLayout.CENTER));

        p3.add(b);
        b.addActionListener(new ButtonListener());
    }

    public void init ()
    {
        buildFPanel();
        buildCPanel();
        buildButtonPanel();
        setLayout(new GridLayout(3, 1));
        add(p1);
        add(p2);
        add(p3);
    }
}
