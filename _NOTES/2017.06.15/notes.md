# [CS111B] 2017.06.15

***Chapter 6 & Chapter 7***

### Testing

* you must test vigorously
* ***QA Engineers*** are hired to find problems
* ***beta*** - a project that is released without complete QA approval

### Overloading

* ***overloading methods*** - allows a function of a given name to accept variable number of arguments and variable types of arguments (`sum` can deal with both `int`-s and `double`-s)
    ```java
    // Demo.java
    class Demo
    {
        // sum integers
        public int sum(int a, int b)
        {
            return a + b;
        }

        // overloaded to sum doubles
        public double sum(double a, double b)
        {
            return a + b;
        }

        // overloaded to sum three integers
        public int sum(int a, int b, int c)
        {
            return a + b + c;
        }

        // overloaded to sum three integers
        public String sum(String a, String b)
        {
            return a + b + c;
        }
    }
    ```

### Constructors

* if you don't make your own constructor, a ***default constructor*** will be created for you
    ```java
    // Demo.java
    class Demo
    {
        // default constructor
        // public Demo()
        // {
        // }

        // sum integers
        public int sum(int a, int b)
        {
            return a + b;
        }

        // overloaded to sum doubles
        public double sum(double a, double b)
        {
            return a + b;
        }

        // overloaded to sum three integers
        public int sum(int a, int b, int c)
        {
            return a + b + c;
        }

        // overloaded to sum three integers
        public String sum(String a, String b)
        {
            return a + b + c;
        }
    }

    // DemoDemo.java
    public class DemoDemo
    {
        // gateway/entry into program
        public static void main(String ... args)
        {
            Demo d = new Demo();
            System.out.println("sum1 = " + d.sum(4, 9));
            System.out.println("sum2 = " + d.sum(2.8, 3.9));
            System.out.println("sum3 = " + d.sum(9, 7, 3));
            System.out.println("sum4 = " + d.sum("Abbas", "Alex"));
        }
    }
    ```
* usually, your class should have several constructors, not just one
* when you write your own constructor to override Java's default constructor, you must make your own default constructor
* note that you can overload constructors
    ```java
    class Box
    {
        private int width;
        private int height;
        private int depth;

        // replacement for default constructor
        public Box()
        {
            this.width  = 0;
            this.height = 0;
            this.depth  = 0;

            // or:
            // this.width = this.height = this.depth = 0;
        }

        // cube
        public Box(int dimension)
        {
            this.width  = dimension;
            this.height = dimension;
            this.depth  = dimension;
        }

        public Box(int width, int height, int depth)
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        public int volume()
        {
            return this.width * this.height * this.depth;
        }
    }

    public class DemoBox
    {
        public static void main(String ... args)
        {
            Box b2 = new Box();
            Box b1 = new Box(4);
            Box b2 = new Box(2, 5, 4);

            System.out.println("vol1 = " + b1.volume());
            System.out.println("vol2 = " + b2.volume());
            System.out.println("vol3 = " + b3.volume());
        }
    }
    ```

* if you put these in one file, the ***filename*** should be the name of the class that contains `main`

### `toString`

* when you make a class, you MUST override Java's `toString` to give useful output
    ```java
    class Box
    {
        private int width;
        private int height;
        private int depth;

        public Box()
        {
            this.width  = 0;
            this.height = 0;
            this.depth  = 0;
        }

        // cube
        public Box(int dimension)
        {
            this.width  = dimension;
            this.height = dimension;
            this.depth  = dimension;
        }

        public Box(int width, int height, int depth)
        {
            this.width  = width;
            this.height = height;
            this.depth  = depth;
        }

        public int volume()
        {
            return this.width * this.height * this.depth;
        }

        public String toString()
        {
            return "width = " + width + ", height = " + height + ", depth = " + depth;
        }

        public boolean equals(Box that)
        {
            return (
                this.width  == that.width  &&
                this.height == that.height &&
                this.depth  == that.depth
            );
        }
    }

    public class DemoBox
    {
        public static void main(String ... args)
        {
            Box b1 = new Box(4);
            Box b2 = new Box();
            Box b2 = new Box(2, 5, 4);

            System.out.println("vol1 = " + b1.volume());
            System.out.println("vol2 = " + b2.volume());
            System.out.println("vol3 = " + b3.volume());

            System.out.println("Dimensions of my b1 box is: " + b1);
        }
    }
    ```

### Comparison

* objects should be able to be compared to another object
* to define comparisons, you have to override `equals`

### HW1

* due: 2017.06.22
* assignment: copy assignment to get you used to inputting code, compiling, running, etc.
    * document program
    * print source code
    * print sample of output
    * make a Box class
        * have several constructors (min 3):
            * default
            * parameterized
            * cube
        * have `volume` method
        * have `toString` method
        * have `equals` method
    * make DemoBox class
        * make objects
        * calculate volumes
        * try printing
        * try comparing
        * use `println`
        * test every feature of your box
