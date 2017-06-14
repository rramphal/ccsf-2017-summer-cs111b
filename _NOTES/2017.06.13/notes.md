# [CS111B] 2017.06.13

### NOTES:

#### Go to ACRC to learn:

1. ***how to open a terminal window***
2. ***how to log into `hills` remotely***
3. ***how to use wi-fi:*** `CCSF Student` is fastest; log in with RAM ID
4. ***how to log into `hills`:*** `ssh [USERNAME]@hills.ccsf.edu`

#### To sync files from `hills` to computer:

```bash
rsync -arvxz -e ssh rramphal@hills.ccsf.edu:/pub/cs/amoghtan/cs111b/ /Users/rramphal/Projects/CCSF/ccsf-2017-summer-cs111b/_HILLS

# (-a)     : set archive mode equivalent to -rlptgoD
# (-r)     : (recurse into directories)
# (-v)     : be verbose
# (-x)     : not cross file system boundaries like NFS or Samba
# (-z)     : compress files over network
# (-e ssh) : specify ssh as shell

# If "/" is placed at the end of the source folder, rsync will copy one the content of the folder.
# When not using "/" at the end of source folder, rsync will copy the folder itself and the content of the folder.

# If "/" is placed at the end of the destination folder, rsync will paste the data directly inside the folder.
# When not using "/" at the end of destination folder, rsync will create a folder with that name and paste the data inside that folder.
```

***NOTE: In this class, we have skipped over first 5 chapters of *Java - The Complete Reference [9ed]****

### Erroring

* `System.out` - writes to `stdout` stream
* `System.err` - writes to `stderr` stream

### Declaration keywords:

* `void`    : method does not return anything
* `static`  : method independent of any object (instance method)
* `public`  : everyone can use them
* `private` : usable only within current class

### Variables

* two types of variables:
    * variables: `int age = 89`
    * constants:
        * `final int DAYS_IN_WEEK = 7` // convention: caps, underscores
        * `final` makes the variable immutable

### Methods

* methods are the foundation of Java
* "argument" and "parameter" mean the same thing
* basic method:
    ```java
    public static void hello()
    {
        System.out.println("Hello, John");
    }

    hello() //=> "Hello, John"
    ```
* refactored for reusability - accept argument:
    ```java
    public static void hello(String name)
    {
        System.out.println("Hello, " + name);
        // here, the `+` is a *concatenation operator*
    }

    hello("John")  //=> "Hello, John"
    hello("Susan") //=> "Hello, Susan"

    // if you type:
    hello()
    // you will get an Argument error
    ```
* refactored for variable number of variables and default value
    ```java
    public static void hello(String ... names)
    {
        if (names.length == 0)
        {
            System.out.println("Hello, Abbas");
        }
        else
        {
            for (String name : names)
            {
                System.out.println("Hello, " + name);
                // here, the `+` is a *concatenation operator*
            }
        }
    }

    hello("John") //=> "Hello, John"
    hello("Susan") //=> "Hello, Susan"
    hello("John", "Susan") //=> "Hello, John\nHello, Susan"
    hello() //=> "Hello, Abbas"
        ```
### Library - a collection of methods

* usage:
    ```java
    // DemoPrintln.java
    public class DemoPrintln
    {
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
            else for (Object obj : o)
            {
                System.out.print("" + obj + "\t");
            }

            System.out.println("");
        }

        public static void main(String ... orgs)
        {
            println("This is a demo program");
            println("made by Abbas to facilitate");
            println("our Java programming.");
        }
    }
    ```
* ***NEVER*** import `java.lang.*`

### Example of a method that returns something

```java
public static double average(int a, int b, int c)
{
    return ((a + b + c) / 3.0);
}

int num1 = 5;
int num2 = 12;
int num3 = 8;

double avg = average(num1, num2, num3);

println("The average is: " + avg);
```
