import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DemoTextField" height="200" width="500"></applet>

public class DemoTextField extends Applet implements ActionListener
{
    TextField name;
    TextField password;

    char BULLET = 8226;

    public void init ()
    {
        Label nameLabel = new Label("name", Label.RIGHT);
        Label passwordLabel = new Label("password", Label.RIGHT);

        name = new TextField(12);
        password = new TextField(8);

        password.setEchoChar(BULLET);

        add(nameLabel);
        add(name);

        add(passwordLabel);
        add(password);

        name.addActionListener(this);
        password.addActionListener(this);
    }

    public void actionPerformed (ActionEvent event)
    {
        repaint();
    }

    public void paint (Graphics g)
    {
        g.drawString("Name: " + name.getText(), 6, 60);
        g.drawString("Selected text in name: " + name.getSelectedText(), 6, 80);
        g.drawString("Selected text in name: " + name.getSelectedText(), 6, 80);
        g.drawString("Password: " + password.getText(), 6, 100);
    }
}
