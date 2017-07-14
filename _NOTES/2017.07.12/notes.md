# [CS111B] 2017.07.12

### Graphics

* new callback: `repaint()`
    * keeps connection to browser
    * repaints entire applet window
    * it then calls `update()`
        * clears the applet window
        * call `paint()`
* `repaint (int delay)` depends on Browser's delay mechanism and is therefore ureliable
* instead, we should just repaint just the section that has changed using
  `repaint (int x, int y, int w, int h)` along with our own delay function

```java
try
{
    Thread.sleep(int milliseconds)
}
catch (InterruptedException e) {}
```

* [see DemoApplet.java]

* `Dimension` only has `width` and `height`
* `Point` only has `x` and `y`

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
