# [CS111B] 2017.06.19

**Chapter 7**

### JVM

* **Java Virtual Machine (JVM)** is what `java` calls to run Java code

### Static classes / methods

* **static methods** also called "**class methods**"
* they require static environments
* does not require an instance to be able to call methods
* without creating an object, you can directly use it
    ```java
    // static
    Math.sqrt(49) //=> 7

    // vs

    // not static
    Date d = new Date();
    ```
* Calc example:
    ```java
    // Calc.java
    public static Calc
    {
        public static int add(int x, int y)
        {
            // parentheses here are Abbas' preference
            return (x + y);
        }

        public static int sub(int x, int y)
        {
            // parentheses here are Abbas' preference
            return (x - y);
        }
    }

    // DemoCalc.java
    public DemoCalc
    {
        public static void main(String ... args)
        {
            int sum  = Calc.add(3, 5);
            int subt = Calc.sub(10, 7);

            System.out.println("sum = " + sum);
            System.out.println("subt = " + subt);
        }

        // static methods require static environment
        // this method will error because it is not static:
        public void doIt()
        {
            int k = Calc.add(4, 10);
        }
    }
    ```

### toString

* provides a meaningful output from your object

### Copying objects

* **aliasing objects**
    ```java
    // `b1` and `b2` are both pointing to the exact same object (in memory)
    Box b1 = new Box(2, 4, 4);
    Box b2 = b1;
    ```
* **duplicating objects**
    ```java
    // Box.java
    class Box
    {
        int width;
        int height;
        int depth;

        public Box(int width, height, depth);
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        // note that you can specify the exact data type
        // you don't just have to say "Object", you can specifically say "Box"
        public Box(Box object)
        {
            this.width  = object.width;
            this.height = object.height;
            this.depth  = object.depth;
        }
    }

    Box b2 = new Box(2, 4, 5);
    Box b1 = new Box(b1);
    ```

### Garbage Collection

* in some languages (C++, etc.), you'll need to write a **`destructor`** to manage memory
* this is automatically done for you in Java
* **garbage collector (gc)** will come (sporadically - not dependable) and delete unused objects
    ```java
    // Box.java
    class Box
    {
        int width;
        int height;
        int depth;

        public Box(int width, height, depth);
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        // note that you can specify the exact data type
        // you don't just have to say "Object", you can specifically say "Box"
        public Box(Box object)
        {
            this.width  = object.width;
            this.height = object.height;
            this.depth  = object.depth;
        }
    }

    Box b1 = new Box(2, 4, 5); // even though the variable is being reassigned, this object still exist in memory until gc comes and deletes it
    b1 = new Box(3, 9, 1);     // even though the variable is being reassigned, this object still exist in memory until gc comes and deletes it
    b1 = new Box(1, 2, 5);
    ```
* sometimes, before the garbage collector clears the memory, you want to do something — you can use `finalize` to do run some code JUST before garbage collector comes:
    ```java
        public void finalize()
        {
            // CODE HERE
        }
    ```

### Memory Leaks

* Two types of memory:
    * **dynamic memory (heap)**
    * **static memory (RAM)**
* when you create any variables, they are automatically created in static memory (RAM); whatever is left will automatically be removed by the operating system
* HOWEVER, it does not clean up dynamic memory (heap) until reboot
* heaps are where objects are stored
* with languages that do not manage memory for you, YOU will have to manage it yourself
* if you don't, this will result in a memory leak that will crash your computer over time
* very tricky to find memory leaks in a large program

### Providing data

* hardcoding is the worst option
    * advantage: simple
    * disadvantage: not reusable

    ```java
    // Demo1.java
    class Demo1
    {
        public static void main(String ... args)
        {
            int a = 5;
            int b = 9
            System.out.println("a + b = " + (a + b));
        }
    }
    ```
* ask for data interactively
    * advantage:
    * disadvantage:
    * use Scanner to prompt user for data - allows us to get data interactively (https://www.cs.utexas.edu/users/ndale/Scanner.html)
        * **`int nextInt()`**: Returns the next token as an int. If the next token is not an integer,`InputMismatchException` is thrown.
        * **`long nextLong()`**: Returns the next token as an integer. If the next token is not a long, `InputMismatchException` is thrown.
        * **`float nextFloat()`**: Returns the next token as a float. If the next token is not a float or is out of range, `InputMismatchException` is thrown.
        * **`double nextDouble()`**: Returns the next token as a long. If the next token is not a float or is out of range, `InputMismatchException` is thrown.
        * **`String next()`**: Finds and returns the next complete token from this scanner and returns it as a string; a token is usually ended by whitespace such as a blank or line break. If not token exists, `NoSuchElementException` is thrown.
        * **`String nextLine()`**: Returns the rest of the current line, excluding any line separator at the end.
        * **`void close()`**: Closes the scanner.
    * NEVER use `println` for prompts, must use `print`

    ```java
    // Demo2.java
    class Demo2
    {
        public static void main(String ... args)
        {
            System.out.print("Give me two numbers: ");
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt(); // gets first token as integer
            int num2 = scanner.nextInt(); // gets second token as integer
            System.out.println("sum = " + (num1 + num2));
        }
    }
    ```

* ask for data interactively within a loop
    * advantage:
    * disadvantage:
    * you must always stop all infinite loops sometime
    * CS believes that everything is finite
    * **sentinel value** - any special data that is used to stop infinite loops (also called a **flag**)
    * easiest infinite loop: `for(;;)`

    ```java
    // Demo3.java
    import java.io.*;
    import java.util.Scanner;

    class Demo3
    {
        public static void main(String ... args)
        {
            int num1;
            int num2;

            Scanner scanner = new Scanner(System.in);

            for(;;)
            {
                System.out.print("Give me two numbers: ");
                int num1 = scanner.nextInt(); // gets first token as integer
                if (num1 == 0) break; // sentinel value
                int num2 = scanner.nextInt(); // gets second token as integer
                System.out.println("sum = " + (num1 + num2));
            }
        }
    }
    ```

* pass data into file usings **args**
    * advantage:
    * disadvantage:
    * `args` is responsible for getting all the data items passed at the command-line level; returns them as an array
    * data is part of the command-line command:
        * `> java Delete file1 file2 file3`
        * `> java Sum 2 5 3 8 1`
    * any command-line command consists of two parts:
        * command
        * data
