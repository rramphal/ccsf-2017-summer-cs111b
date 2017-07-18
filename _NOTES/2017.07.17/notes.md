# [CS111B] 2017.07.17

### FontMetrics

* `FontMetrics [FontMetrics] = [Graphics].getFontMetrics();`
* `int [FontMetrics].charWidth(char character)`
* `int [FontMetrics].getHeight(char character)`
* `int [FontMetrics].stringWidth(String string)`

### Debugging Applets

* the last row of your applet area is designated for `showStatus`
* `public void showStatus(String string)`

```java
public void clearScreen (int x, int y, int width, int height)
{
    Graphics g = getGraphics();
    g.setColor(getBackground());
    g.fillRect(x, y, width, height);
    g.setColor(getForeground());
    g.dispose();
}
```

### Running Applets on `hills`

```java
<object
    codetype="application/java"
    classid="java:Hello.class"
    width="300"
    height="250"
></object>
```

### Widgets (Graphics Elements / GUI Elements)

* **Graphical User Interface (GUI)**
* buttons, menus, sliders, select dropdowns, text fields
* almost all are **active** - creating events
* buttons create `ActionEvent`
* keyboards create `KeyEvent`
* if you catch an event, you can do something with it (**event handling**)
* if you don't catch an event, nothing happens

### FlowLayout
    * default layout manager
    * defaults to putting widgets side by side (inline) - will break line when space has run out
    * defaults to center-justified
    * three panes:
        * glass pane: front layer in charge of GUI elements (layout manager)
        * content pane: graphics context layer
        * layered pane: graphics context layer
        * (root pane at the very bottom)

### Label

* displays a String (similar to `drawString`)
* does not create event (not active --> **passive**)
* cannot be used in `paint` because `paint` uses `Graphics`, but `Label` does not use `Graphics`
* constructors:
    * `Label()` - creates an empty label
    * `Label(String string)`
    * `Label(String string, int alignment)` - `alignment` can either be: `Label.LEFT`, `Label.RIGHT`, `Label.CENTER`
* `void [Label].setFont(Font font)`
* `String [Label].getText()`
* `int [Label].getAlignment()`

* See [`Labels.java`]

### Button
