# [CS111B] 2017.07.13

### Params

```java
<applet code="Demo.java" height="300" width="400"> <!-- params -->
    <param name="age" value="92">
    <param name="car" value="BMW">
</applet>
```

* `String getParameter(String keyName)` - returns corresponding value if found; otherwise returns `null`

```java
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

```

### VariableRectangle

```java
// > javac VariableRectangle.java && appletViewer VariableRectangle.java

import java.awt.*;
import java.applet.*;

// <applet code="VariableRectangle.java" width="500" height="400">
//     <param name="width" value="250">
//     <param name="height" value="200">
// </applet>

@SuppressWarnings("serial")
public class VariableRectangle extends Applet
{
    int width;
    int height;

    public void init ()
    {
        String widthParam  = getParameter("width");
        String heightParam = getParameter("height");

        width  = Integer.parseInt(widthParam);
        height = Integer.parseInt(heightParam);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(10, 10, width, height);
    }
}
```

### DrawArc

* counter-clockwise movement

```java
// > javac DrawArc.java && appletViewer DrawArc.java

import java.awt.*;
import java.applet.*;

// <applet code="DrawArc.java" width="500" height="400">
//     <param name="x" value="10">
//     <param name="y" value="10">
//     <param name="arcWidth" value="80">
//     <param name="arcHeight" value="70">
//     <param name="startAngle" value="0">
//     <param name="sweepAngle" value="145">
// </applet>

@SuppressWarnings("serial")
public class DrawArc extends Applet
{
    int x;
    int y;
    int arcWidth;
    int arcHeight;
    int startAngle;
    int sweepAngle;

    public void init ()
    {
        x          = Integer.parseInt(getParameter("x"));
        y          = Integer.parseInt(getParameter("y"));
        arcWidth   = Integer.parseInt(getParameter("arcWidth"));
        arcHeight  = Integer.parseInt(getParameter("arcHeight"));
        startAngle = Integer.parseInt(getParameter("startAngle"));
        sweepAngle = Integer.parseInt(getParameter("sweepAngle"));
    }

    public void paint(Graphics g)
    {
        // g.drawArc(x, y, arcWidth, arcHeight, startAngle, sweepAngle);
        g.fillArc(x, y, arcWidth, arcHeight, startAngle, sweepAngle);
    }
}
```

### DrawTriangle

```java
public void drawTriangle (int x1, int y1,
                          int x2, int y2,
                          int x3, int y3)
{
    Graphics g = getGraphics(); // is created in the heap (and won't be cleaned up by garbage collection)
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y2, x3, y3);
    g.drawLine(x3, y3, x1, y1);
    g.dispose(); // this explicitly removes it from the heap
}
```

### DrawPolygon

```java
// > javac DrawPolygon.java && appletViewer DrawPolygon.java

import java.awt.*;
import java.applet.*;

// <applet code="DrawPolygon.java" width="500" height="400">
//     <param name="x" value="10">
//     <param name="y" value="10">
// </applet>

@SuppressWarnings("serial")
public class DrawPolygon extends Applet
{
    int x;
    int y;

    public void init ()
    {
        x = Integer.parseInt(getParameter("x"));
        y = Integer.parseInt(getParameter("y"));
    }

    public void paint(Graphics g)
    {
        // g.drawPolygon(int[] x, int[] y, int numSides);
        // g.fillPolygon(int[] x, int[] y, int numSides);
        int[] x = { 30, 200, 300, 200, 30 };
        int[] y = { 30,  30, 200, 200, 30 };
        g.drawPolygon(x, y, x.length);
    }
}
```

### Display All Fonts

```java
import java.awt.*;

public class ShowFonts
{
    public static void main (String ... args)
    {
        String[] fontList;

        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

        fontList = ge.getAvailableFontFamilyNames();

        System.out.println(fontList.length + " fonts:");

        for (String font : fontList)
        {
            System.out.println("    * " + font);
        }
    }
}
```

### Working With Fonts

* `Font(String name, int style, int size)`
* styles:
    * `Font.PLAIN`
    * `Font.BOLD`
    * `Font.ITALIC`
* you can combine styles using pipe: `Font.BOLD|Font.ITALIC` (bitwise OR)

```java
// Font(String name, int style, int size)
Font f = new Font("Serif", Font.PLAIN, 20);
setFont(f);
```

* `int [Font].getStyle()`
* `Font [Graphics].getFont()`
* `int [Font].getSize()`
* `String [Font].getName()`

### Homework Assignment 5

* Screensaver
* width and height set to screen size
* random shapes set by params
* random color
* random location
