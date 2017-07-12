# [CS111B] 2017.07.10

* 2017.07.17 - Quiz 2

### Compacting Code

* Static import
    ```java
    import static java.lang.Math.*;
    import static java.lang.System.*;

    private static void die(String errorMessage)
    {
        err.println(errorMessage);
        exit(1);
    }

    public static int hypotenuse (int a, int b)
    {
        return sqrt(pow(a, 2) + pow(b, 2));
    }
    ```

* **esoteric features** - hidden, undocumented features of a language
    * Renaming classes
        ```java
        Math $ = null;

        $.sqrt(49);
        ```

        ```java
        Integer $ = null;

        $.parseInt("284");
        ```

        ```java
        System $ = null;

        $.exit(0);
        ```

* Using `Console`
    * no useful **constructor**
    * instead it has a **factory method**
        * a method that creates an object for you, but is not restricted by name of class
        * MUST be `static`
    * you are DIRECTLY working with the `console` - MUCH faster than `Scanner`
    * you need to make sure that the console was created
    * useful to accept passwords

    ```java
    Console con = System.console();

    if (con == null) die("no console");

    String str = con.readLine("Your Name: ");

    char c[] = con.readPassword("Your Password: ");
    ```

### ArrayList

* dynamic array - not limited by size
* only accepts OBJECTS (`Integer`, `Character`)
* `boolean [ArrayList].add(value)`
* `boolean [ArrayList].add(location, value)`
* `boolean [ArrayList].contains(value)`
* `[valueType] [ArrayList].get(value)`
* `[valueType] [ArrayList].set(location, value)`
* `integer [ArrayList].size()`
    ```java
    ArrayList<Integer> list = new ArrayList<Integer>(); // before Java 6
    // ArrayList<Integer> list = new ArrayList<>(); // after Java 6
    list.add(25); // element 0 <25>
    list.add(18); // element 1 <25, 18>
    list.add(40); // element 2 <25, 18, 40>
    list.add(10, 22) // throws IndexOutOfBoundsException <25, 18, 40>

    list.add(1, 36); // will insert at index 1 and push everything else down <25, 36, 18, 40>

    list.contains(25); // returns true <25, 36, 18, 40>
    list.get(0); // returns 25 <25, 36, 18, 40>
    list.size(); // returns 4 <25, 36, 18, 40>

    list.set(0, 33); // <33, 36, 18, 40>

    System.out.println(list); // will display contents

    for (int num : list) println(num); // foreach loops also work with ArrayLists

    list.clear(); // empties ArrayList

    // converting to `Array`
    int[] ages = new int[list.size()];
    ages = list.toArray(ages);
    ```

### Reading/Writing to Files

* you don't need to close the file if you use this approach:
```java
try(Scanner scanner = new Scanner([File]))
{
    // ...
}
catch (IOException e) {}
// file automatically closed
```

### Graphics

* three different graphic engines available in Java
    * AWT (Abstract Window Toolkit)
    * Swing
    * JavaFX
* **applet** - small Java program that is transferred from the web server to the client and runs by your web browser
    * by nature, everything within an applet is pure graphics
    * potential security holes
    * restrictions
        * cannot write to files
        * cannot access operating system
    * **callbacks** - programs that are not called directly by programmers
    * **lifecycle**:
        * `public void init()` - called only once at the very beginning of the program; automatically calls `start()` - entry point (similar to `main()`)
        * `public void start()` - will then call `paint()`
        * `public void paint(Graphic g)` - paints the screen; pt graphical things here
        * `public void stop()` - called when the program is about to finish; will then call `destroy()`
        * `public void destroy()` - kills the applet
    *  each lifecycle method has their own default implementation - you don't have to overwrite them, but you probably will have to
    * when you are creating applets, a minimum of two classes needs to be imported
    * any applet MUST subclass the `Applet` class (provides `init()`, `start()`, `stop()`, `destroy()`)
    * you can run your applet without the browser by using appletViewer
        ```java
        // DemoApplet.java

        import java.awt.*;
        import java.applet.*;

        public class DemoApplet extends Applet
        {
            // public void init() {}

            // public void start() {}

            public void paint (Graphics g)
            {
                // [Graphics].drawString(String string, int x, int y)
                // (0, 0) is the top-left-most pixel
                // no negative values
                // default color: white/gray background, black foreground
                g.drawString("Hello Applet", 20, 30);
            }

            // public void stop() {}

            // public void destroy() {}
        }
        ```

        ```html
        <!-- DemoApplet.html -->

        <applet
            code="DemoApplet"
            height="300"
            width="400"
        ></applet>
        ```

        ```bash
        > appletViewer DemoApplet.html
        ```
    * you can also write the applet tag directly into to the `.java` file
        ```java
        // DemoApplet.java

        import java.awt.*;
        import java.applet.*;

        // <applet code="DemoApplet" height="300" width="400"></applet>

        public class DemoApplet extends Applet
        {
            // public void init() {}

            // public void start() {}

            public void paint (Graphics g)
            {
                // [Graphics].drawString(String string, int x, int y)
                // (0, 0) is the top-left-most pixel
                // no negative values
                // default color: white/gray background, black foreground
                g.drawString("Hello Applet", 20, 30);
            }

            // public void stop() {}

            // public void destroy() {}
        }
        ```

        ```bash
        > appletViewer DemoApplet.java
        ```
* Standalone program
