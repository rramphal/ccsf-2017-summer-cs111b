# [CS111B] 2017.06.14

***If you make things easy for you, you will make it harder for the user. You must do what is hard for you so that it is easier for the user.***

***Beginning of Ch. 6***

### Objects

* Base Example:
    ```java
        class Box
        {
            int width;
            int height;
            int depth;
        }

        public class DemoBox
        {
            public static void main(String ... args)
            {
                // `b` points/refers to the `Box` class in memory
                Box b = new Box();
                // b is an object

                // accessing variables directly is bad practice
                // will be fixed later
                b.width  = 4;
                b.height = 6;
                b.depth  = 3;

                int volume = b.width * b.height * b.depth;
                System.out.println("The volume is: " + volume);
            }
        }
    ```
* any Java program that is executable MUST have a `main` method
* an ***object*** is an instance of a class in memory
* to create an object (an instance of a class), you must use the keyword `new`
* an object without any data is not very useful
* we don't want to access variables directly - let's add protection with `private` and ***getters/setters***
* setters and getters are ALWAYS `public`
* setters ALWAYS return `void`
    ```java
        class Box
        {
            private int width;
            private int height;
            private int depth;

            // shorthand for individual setters below
            public void setDimensions(int width, int height, int depth)
            {
                // you don't have to use `this.`, but it is better for disambiguating
                // in this case, we MUST use `this.` since the instance variables and the arguments are the same name
                this.width  = width;
                this.height = height;
                this.depth  = depth;
            }

            public void calculateVolume()
            {
                return this.width * this.height * this.depth;
            }

            public int getWidth()
            {
                return this.width;
            }

            public void setWidth(int width)
            {
                this.width = width;
            }

            public int getHeight()
            {
                return this.height;
            }

            public void setHeight(int height)
            {
                this.height = height;
            }

            public int getDepth()
            {
                return this.depth;
            }

            public void setDepth(int depth)
            {
                this.depth = depth;
            }
        }

        public class DemoBox
        {
            public static void main(String ... args)
            {
                Box b = new Box();
                b.setDimensions(4, 6, 3);

                System.out.println("The volume is: " + b.calculateVolume());
            }
        }
    ```
* `static` methods only work within static environments (`main`)
* Java allows us to replace many setters with one ***constructor***
    ```java
        class Box
        {
            private int width;
            private int height;
            private int depth;

            // let's replace many settings with one constructor
            // note that it is the same name as my class
            // THERE IS NO RETURN TYPE
            // MUST be public
            public Box(int width, int height, int depth)
            {
                this.width = width;
                this.height = height;
                this.depth = depth;
            }
        }

        public class DemoBox
        {
            public static void main(String ... args)
            {
                Box b = new Box(4, 6, 3);
                System.out.println("The volume is: " + b.calculateVolume());
            }
        }
    ```
* ***parameterized constructors*** help us initialize state
* there are no relationships between different instances of the same class
    ```java
        class Box
        {
            private int width;
            private int height;
            private int depth;

            // let's replace many settings with one constructor
            // note that it is the same name as my class
            // THERE IS NO RETURN TYPE
            // MUST be public
            public Box(int width, int height, int depth)
            {
                this.width  = width;
                this.height = height;
                this.depth  = depth;
            }
        }

        public class DemoBox
        {
            public static void main(String ... args)
            {
                Box b1 = new Box(4, 6, 3);
                System.out.println("The volume is: " + b1.calculateVolume());

                Box b2 = new Box(2, 5, 3);
                System.out.println("The volume is: " + b2.calculateVolume());

                Box b3 = new Box(4, 5, 1);
                System.out.println("The volume is: " + b3.calculateVolume());
            }
        }
    ```
* the majority of the classes that you write should have a `show` function: a function that shows the values of all the values in your instance
    ```java
        class Box
        {
            private int width;
            private int height;
            private int depth;

            // let's replace many settings with one constructor
            // note that it is the same name as my class
            // THERE IS NO RETURN TYPE
            // MUST be public
            public Box(int width, int height, int depth)
            {
                this.width  = width;
                this.height = height;
                this.depth  = depth;
            }

            public void show()
            {
                System.out.println("width: " + this.width);
                System.out.println("height: " + this.height);
                System.out.println("depth: " + this.depth);
            }
        }

        public class DemoBox
        {
            public static void main(String ... args)
            {
                Box b1 = new Box(4, 6, 3);
                System.out.println("The volume is: " + b1.calculateVolume());

                Box b2 = new Box(2, 5, 3);
                System.out.println("The volume is: " + b2.calculateVolume());

                Box b3 = new Box(4, 5, 1);
                System.out.println("The volume is: " + b3.calculateVolume());
            }
        }
    ```
