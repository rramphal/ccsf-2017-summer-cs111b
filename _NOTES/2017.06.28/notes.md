# [CS111B] 2017.06.28

### Abstract Classes

* Java says that if you haven't completed your class, you must make it an abstract class
* **abstract class** - a class from which you cannot create an object
* when you are completing an abstract class, you should NOT modify the original abstract class and must instead inherit

    ```java
    public abstract class AddSubtCalc
    {
        public int add(int a, int b)
        {
            return a + b;
        }

        public int subt(int a, int b)
        {
            return a - b;
        }

        // these are incomplete
        public abstract int mult(int a, int b);
        public abstract int div(int a, int b);
    }

    public abstract class AddSubtMultCalc extends AddSubtCalc
    {
        public int mult(int a, int b)
        {
            return a * b;
        }
    }

    // instantiable
    // contains all four methods
    public class Calc extends AddSubtMultCalc
    {
        public int div(int a, int b)
        {
            return a / b;
        }
    }
    ```
* example from textbook (pg. 183)
    ```java
    // Using abstract methods and classes.
    abstract class Figure {
        double dim1;
        double dim2;

        Figure(double a, double b) {
            dim1 = a;
            dim2 = b;
        }

        // area is now an an abstract method
        abstract double area();
    }

    class Rectangle extends Figure {
        Rectangle(double a, double b) {
            super(a, b);
        }

        // override area for rectangle
        double area() {
            System.out.println("Inside Area for Rectangle.");
            return dim1 * dim2;
        }
    }

    class Triangle extends Figure {
        Triangle(double a, double b) {
            super(a, b);
        }

        // override area for right triangle
        double area() {
            System.out.println("Inside Area for Triangle.");
            return dim1 * dim2 / 2;
        }
    }

    class AbstractAreas {
        public static void main(String args[]) {
            // Figure f = new Figure(10, 10); // illegal now
            Rectangle r = new Rectangle(9, 5);
            Triangle t = new Triangle(10, 8);

            Figure figref; // this is OK, no object is created

            figref = r;
            System.out.println("Area is " + figref.area());

            figref = t;
            System.out.println("Area is " + figref.area());
        }
    }
    ```

### Interfaces

* **interfaces** were originally created to fix the problems caused by single inheritance in Java
* contains all of the incomplete methods - ALL methods are abstract
* they contain ONLY the **signature** of the methods, NEVER the implementations
* defaults to public because they MUST be public
* unlike with classes, you are able to implement as many interfaces as you like

    ```java
    interface AddSubt
    {
        public int add(int a, int b);
        public int subt(int a, int b);
    }

    interface MultDiv
    {
        public int mult(int a, int b);
        public int div(int a, int b);
    }

    public class Calc implements AddSubt, MultDiv
    {
        public static int add(int a, int b)
        {
            return a + b;
        }

        public static int subt(int a, int b)
        {
            return a - b;
        }

        public static int mult(int a, int b)
        {
            return a * b;
        }

        public static int div(int a, int b)
        {
            return a / b;
        }

        // can add custom methods too
        public static int square(int a)
        {
            return a * a;
        }
    }

    public class Demo
    {
        public static void main(String ... args) {
            Calc calc = new Calc();
            int x = calc.add(2, 5);
            int y = calc.subt(18, 10);
            System.out.println("x = " + x + " y = " + y);
        }
    }
    ```
* whichever class that is using an interface must implement the methods (known as the **implementor**)
* if you don't want others to use our class or methods, we use `final` to stop inheritance
* textbook pg. 196 (pre-Java 8)
* interfaces can be used to make a data file
    ```java
    interface Data
    {
        String name = "John";
        int age = 38;
        double salary = 42000;
        int MAX_AGE = 150;
    }

    class Demo implements Data
    {
        public static void main(String ... args) {
            System.out.println("I hope somebody becomes " + MAX_AGE + " years old");
        }
    }
    ```
* all variables that you create in interfaces are `final`, so you don't need to use the keyword
* in Java 8, many improvements were made on interfaces
    * now you could implement some of the methods
    * addition of **functional** interface - an interface with only ONE signature
        * main source of information for lambda expressions
        * may have static methods

### Package

* **packages** are a way to contain one or more (COMPILED) classes/interfaces
* at the beginning of the file, use the keyword `package`
    ```java
    // Calc.java
    package com.love;

    public class Calc
    {
        //
    }

    // Demo.java
    package com.love;

    public class Demo
    {
        //
    }
    ```
* if when you run `javac Calc.java` and then `javac Demo.java`, the `com.love` package will be created containing both classes
* you then put your package into a `.jar` file to share (compressed)
* naming convention: should be in the format of a reverse domain: `com.love.is.good` - to be a unique name
