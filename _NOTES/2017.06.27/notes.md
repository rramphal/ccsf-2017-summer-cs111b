# [CS111B] 2017.06.27

Java REPL: http://www.javarepl.com/

### Ineritance

* makes functionality from one class available to another
* you can also **override** superclass methods
* you can also use the **annotation** `@Override` so that Java checks for the existence superclass
* other annotations include: `@Deprecated`, `@Override`, `@SuppressWarning`
    ```java
    public class Calc
    {
        public static int add(int x, int y)
        {
            return x + y;
        }

        public static int div(int x, int y)
        {
            return x / y;
        }
    }

    public class BetterCalc extends Calc
    {
        public static int subt(int x, int y)
        {
            return x - y;
        }

        public static int mult(int x, int y)
        {
            return x * y;
        }

        @Override
        public static int div(int x, int y)
        {
            if (y != 0)
            {
                // super.div(x, y) won't work in a static context
                return x / y;
            }
            else
            {
                System.err.println("error: division by 0");
            }
        }
    }
    ```
* overloading - accepting more parameters to a method (polymorphism)
* overriding - replacing a method (inheritance)
* the topmost class that everything inherits from is called **`Object`**
* all `Object` methods are available to ALL Java classes:
    * `equals`
    * `toString`
* `Object` allows us to write flexible methods
    ```java
   public static void println(Object ... o)
   {
      if (o.length == 0)
      {
         System.out.print("");
      }
      else if (o.length == 1)
      {
         System.out.print("" + o[0]);
      }
      else for(Object obj : o)
      {
         System.out.print("" + obj + "\t");
      }
      System.out.println("");
   }
      ```
* you can use **decompilers** / **anti-compilers** to reverse engineer: Mocha

```java
class Box
{
    int width;
    int height;
    int depth;

    public Box(int ... x)
    {
        if (x.length == 0) // default
        {
            width = height = depth = 0;
        }
        else if (x.length == 1) // dimension
        {
            width = height = depth = x[0];
        }
        else if (x.length == 3) // parameterized
        {
            width  = x[0];
            height = x[1];
            depth  = x[2];
        }
        else
        {
            System.err.println("Invalid number of arguments");
        }
    }
}
```

* when you have many if/else-s, **switch statement**s might help (and they are slightly faster)
* you can use whichever sequence that you want
    ```java
    class Box
    {
        int width, height, depth;

        public static void die(String errorMessage)
        {
            if (message.length > 0) System.err.println(errorMessage);
            System.exit(1);
        }

        public Box(int ... x)
        {
            switch (x.length)
                case 0: // zero default
                    width = height = depth = 0;
                    break;
                case 1: // cube
                    width = height = depth = x[0];
                    break;
                case 3:
                    width  = x[0];
                    height = x[1];
                    depth  = x[2];
                    break;
                default:
                    System.err.println("Invalid number of arguments provided to constructor");
        }
    }
    ```

### StringBuilder

* automatically expands to allow for more capacity (transparently)
* `append` is overloaded to accept different types of data
    ```java
    StringBuilder sb = new StringBuilder();
    sb
        .append("John") // 4 characters  (12 left)
        .append('A')    // 5 characters  (11 left)
        .append(45)     // 7 characters  (9 left)
        .append(true)   // 11 characters (5 left)
        .append(3.14)   // 15 characters (1 left)
        .append('B')    // 16 characters (0 left)
        .append('C')    // 17 characters (17 left) [capacity doubled and two added to accomodate new string length]
    ;
    ```
* `StringBuilder` can take a integer to initialize a StringBuilder with a length (`StringBuilder sb = new StringBuilder(200);`)
* `[StringBuilder].length()`
* `[StringBuilder].capacity()`
* `[StringBuilder].ensureCapacity()`
* `[StringBuilder].delete(int start, int end)` (`end` is one beyond)
* `[StringBuilder].deleteCharAt(int location)`
* `[StringBuilder].insert(int location, [Object] content)`
* `[StringBuilder].indexOf(String query)`
* use `[StringBuilder].toString()` at the end to convert back to a String
