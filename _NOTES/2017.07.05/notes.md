# [CS111B] 2017.07.05

### Quiz

* Strings are compared using `.equals()`
* length of string is `[str].length()`
* `Character.isDigit([charValue])`, NOT `[char].isDigit()`

### Appending to Files

* must use `FileWriter` to append
* if you pass `true` as the second parameter in the constructor, it will append; if not, it will overwrite
* `FileWriter` does not have `print()` or `println()`, it has `write()` - allows you to write ONE character (`write(char c)`) or an array of characters to file (`write(char[] array, int offset, int length)`)
* passing an instance of `FileWriter` into `PrintWriter` allows us to use `print()` and `println()`

### Homework

```java
import java.io.*;
import java.util.*;

public NameSwapper
{
    private static void die()
    {
        System.out.println("\nExiting.");
        System.exit(0);
    }

    public static File checkFile(String filename)
    {
        if (filename.length < 1) die("Filename not provided");

        File file = new File(filename);

        if (!file.exists())      die(filename + " does not exist!");
        if (!file.isFile())      die(filename + " is not a file!");
        if ( file.isDirectory()) die(filename + " is a directory!");
        if (!file.canRead())     die(filename + " cannot be read!");

        return file;
    }

    public static String processLine(String line)
    {
        line.split(',')
    }

    public static String iterateFile(File file)
    {
        // Scanner opens the file
        Scanner scanner = new Scanner(checkFile(file));
        String line;

        while(scanner.hasNext())
        {
            line = scanner.nextLine();
        }

        file.close();
    }

    public static String writeToFile(String line)
    {
        if () // doesn't exist and if it does, make sure you can write AND that it is empty)
        PrintWriter printWriter = new PrintWriter("datafix.fix");
        printWriter.println(line);
        printWriter.close();
    }

    public static String appendToFile(String line)
    {
        if () // doesn't exist and if it does, make sure you can write AND that it is empty)
        FileWriter fileWriter = new FileWriter("datafix.fix", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("I got a good.");
    }

    public static void main (String ... args) throws IOException
    {

    }
}
```

### Random Number Generator

* uniqueness is not guaranteed

* `Math.random()` generates a decimal between 0 (inclusive) and 1 (exclusive)
    ```java
    private static int rand(int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }
    ```
* Die example
    ```java
    public static void main(String ... args)
    {
        int num;
        int count = 0;

        for (int i = 0; i < 100; i++)
        {
            num = rand(1, 6);
            if (num == 6) count++;
            }
        }

        println("Number of 6: " + count);
    }
    ```
* Pair of Dice example
    ```java
    public static void main(String ... args)
    {
        int num1;
        int num2;
        int count = 0;

        for (int i = 0; i < 100; i++)
        {
            num1 = rand(1, 6);
            num2 = rand(1, 6);
            // if (num1 + num2 == 6 + 6) count++; // `+` is slower than `&&` because `&&` compares bits
            if (num1 == 6 && num2 == 6) count++; // faster
            }
        }

        println("Number of 6: " + count);
    }
    ```

* Array example - populate an array of 1000 elements with a random number between 1 and 50,000
    ```java
    int[] num = new int[1000];

    for (int i = 0; i < num.length; i++)
    {
        num[i] = rand(1, 50000);
    }
    ```

### Extra Credit Homework Assignment (10 points) - due next week Wednesday (2017.07.12)

* populate an array with 1000 UNIQUE random numbers between 1 and 2000
* make a method called `isUniq` that returns a boolean representing if all the elements of an array are unique
* approach: sort array and then compare to next neighbor

```java
public static boolean isUniq(int[] x)
{
    Arrays.sort(x); // quicksort

    for(int i = 0; i < x.length - 1; i++)
    {
        if (x[i] == x[i + 1]) return false;
    }
    return true;
}

int[] num = new int[1000];

for (int i = 0; i < num.length; i++)
{
    num[i] = rand(1, 2000);
}

if (isUniq(num)) {

}
```

### Largest and Smallest

```java
int[] ages = {20, 15, 30, 40, 18, 7}
int oldest   = ages[0];
int youngest = ages[0];

for (int i = 1; i < ages.length; i++)
{
    if (age[i] > oldest)   oldest   = age[i];
    if (age[i] < youngest) youngest = age[i];
}

System.out.println("Oldest: " + oldest);
System.out.println("Youngest: " + youngest);
```

### Search

* Sequential Search
    ```java
    int[] ages = {20, 15, 30, 40, 18, 7}
    int target = 40;

    for (int i = 0; i < ages.length; i++)
    {
        if (target == age[i])
        {
            System.out.println("Found.");
            System.exit(0);
        }
    }

    System.out.println("Not found.");
    ```
* Binary Search
* Hash Search
