# [CS111B] 2017.06.21

**Chapter 7, 8, and 9**

### Java

* Java comes with 20,000 classes, average of 100 methods
* `jShell` - Java REPL
* `javap` - analyze any class in Java
* get constructors: `javap [CLASS] | grep "[pattern]"`
* get number of constructors: `javap [CLASS] | grep "[pattern]"` | wc -l

### Tools on `hills`

* `mkjava` - generate Java file from template
* `jcr` - compile and run Java
* `sh.rb -s Box.java` - add method name in comments
* `bu.rb Box.java` - beautify file
* `ij` - interactive Java

### Pass by Reference

* [see `PassByRef.java`]

### Constructors

* revisited
    ```java
    class Box
    {
        int width;
        int height;
        int depth;

        public Box(int width, int height, int depth)
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        public Box(int dimension)
        {
            // call call the parameterized function
            this(dimension, dimension, dimension);
        }
    }
    ```

### Interitance

* Java is a **single inheritance** language (you can only inherit from one class)
* languages like C++, can inherit from more classes
* a **subclass** uses the `extends` keyword to inherit from a **superclass**
* you can use interitance to add *public* methods
    ```java
    // base/super class
    public class Calc
    {
        public static int add(int a, int b)
        {
            return a + b;
        }

        public static int subtract(int a, int b)
        {
            return a - b;
        }
    }

    // subclass
    public class MyCalc extends Calc
    {
        public static int multiply(int a, int b)
        {
            return a * b;
        }

        public static int divide(int a, int b)
        {
            if (b == 0) return;

            return a / b;
        }
    }

    class DemoMyCalc extends MyCalc
    {
        public static void main(String ... args)
        {
            System.out.println("7 + 9" = add(7, 9));
            System.out.println("7 - 9" = subtract(7, 9));
            System.out.println("7 * 9" = multiply(7, 9));
            System.out.println("90 / 9" = divide(7, 9));
        }
    }
    ```
* you can also use inheritance to add new variables
* the keyword `super` calls the superclass' constructor
    ```java
    class Box
    {
        int width;
        int height;
        int depth;

        public Box(int width, int height, int depth)
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        public Box(int dimension)
        {
            // call call the parameterized function
            this(dimension, dimension, dimension);
        }
    }

    class HeavyBox extends Box
    {
        // note that you have to repeat the variable instantiation here (they are not inherited)
        int width;
        int height;
        int depth;

        int weight;

        // parameterized default
        public HeavyBox(int width, int height, int depth, int weight)
        {
            super(width, height, depth);
            this.weight = weight;
        }

        // no-argument, default
        public HeavyBox()
        {
            this(0, 0, 0, 0);
        }
    }
    ```
* if you don't want a class to be inherited, make it `final`
* uninheritable classes: `String`, `System`

### OOP

* based on four important concepts: PIE
    * P: **polymorphism** - capability of overloading methods (having several methods with the same name)
    * I: **inheritance**
    * E: **encapsulation** - being able to put instance variables and methods together

```java
    class Demo1
    {
        int i;
        int j;
    }

    class Demo2 extends Demo1
    {
        int i;
        int k;
    }

    class MyDemo
    {
        Demo1 d = new Demo1();
        d.i = 5;
        d.j = 9;

        Demo2 dd = new Demo2();
        dd.i = 20; // refers to Demo2's `i`
        dd.j = 15; // refers to Demo2's `j`
        dd.k = 32; // refers to Demo2's `k`

        dd.super.i = 10 // refers to Demo1's `i`
    }
```

### Strings

* `javap java.lang.String`
    ```java
        String str = "Today was hot.";

        str.length(); // length is a method of String, but a property of Array
        str.charAt();

        for(int i = 0; i < str.length(); i++)
        {
            System.out.println(str.charAt(i));
        }

        String name1 = "John";
        String name2 = "Susan";

        if (name1.equals(name2))
        // case-sensitive
        {
            //
        }

        if (name1.equalsIgnoreCase(name2))
        // case-INsensitive
        {
            //
        }
    ```
