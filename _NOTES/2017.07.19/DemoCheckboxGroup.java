import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code="DemoCheckboxGroup" height="200" width="500"></applet>

public class DemoCheckboxGroup extends Applet implements ItemListener
{
    String message = "";

    CheckboxGroup checkboxGroup;

    Checkbox checkbox1;
    Checkbox checkbox2;
    Checkbox checkbox3;
    Checkbox checkbox4;

    public void init ()
    {
        checkboxGroup = new CheckboxGroup();

        // when all are true, only the last one will be checked
        // when all are false, all will be unchecked
        checkbox1 = new Checkbox("Windows XP", checkboxGroup, true);
        checkbox2 = new Checkbox("Windows Vista", checkboxGroup, false);
        checkbox3 = new Checkbox("Linux", checkboxGroup, false);
        checkbox4 = new Checkbox("MacOS X", checkboxGroup, false);

        add(checkbox1);
        add(checkbox2);
        add(checkbox3);
        add(checkbox4);

        checkbox1.addItemListener(this);
        checkbox2.addItemListener(this);
        checkbox3.addItemListener(this);
        checkbox4.addItemListener(this);
    }

    public void itemStateChanged (ItemEvent event)
    {
        repaint();
    }

    public void paint (Graphics g)
    {
        message = "current state: ";
        g.drawString(message, 6, 80);

        message = "Windows XP: " + checkbox1.getState();
        g.drawString(message, 26, 100);

        message = "Windows Vista: " + checkbox2.getState();
        g.drawString(message, 26, 120);

        message = "Linux: " + checkbox3.getState();
        g.drawString(message, 26, 140);

        message = "MacOS X: " + checkbox4.getState();
        g.drawString(message, 26, 160);
    }
}
