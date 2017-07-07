# [CS111B] 2017.07.06

* variables can be assigned but not declared inside the conditional statement

### Search

* Sequential Search
    ```java
    public static int sequentialSearch(String[] list, String target)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (target.equals(list[i])) return i;
        }

        return -1;
    }
    ```
* Binary Search
* Hash Search

### Primitive Data Types

* `int`, `double`, etc.
* primitive data types are not objects

### Object Data Types

* `Integer`, `Double`, etc.
* **boxing**: converting `primitive --> Object`
    ```java
    int num = 12;
    Integer x = new Integer(num);
    ```
* **unboxing**: converting `Object --> primitive`
    ```java
    Integer x = new Integer(12);
    int num = x.valueOf();
    ```
* in modern versions of Java, boxing and unboxing is automatically done for you
    ```java
    int x = new Integer(12);
    Integer y = 12;
    ```

### Array

* immutable
    ```java
    int[] age = new Int[5]; // initializes array with 0 in each index
    age[0] = 21;
    age[4] = 16;
    age[5] = 19; // this will throw ArrayIndexOutOfBounds exception
    ```

### Arrays

* `Arrays` does not have any useful constructors
* all the methods are static

### ArrayList

* dynamic array - not limited by size
* only accepts OBJECTS (`Integer`, `Character`)
* `boolean [ArrayList].add(value)`
* `boolean [ArrayList].add(location, value)`
* `boolean [ArrayList].contains(value)`
* `[valueType] [ArrayList].get(value)`
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

    System.out.println(list); // will display contents

    list.clear(); // empties ArrayList

    // converting to `Array`
    int[] ages = new int[list.size()];
    ages = list.toArray(ages);
    ```

### Loading File Into Array

* because we don't know how many lines are in the file so that we can allocate array size, we must load them into an ArrayList and then convert it to an array

```java
public static String[] load(String filename)
{

}
```

### Homework Assignment 04

* `SuperLotto.java`
* california super lotto
* write quickpick program
* each ticket contains a maximum of 10 lines
* pay: $25 > [ 10, 10, 5 ]
* each line is sorted in ascending order
* all numbers are printed with leading zeroes
* each line is prefixed with letters in ascending order [A, B, C]
* 5 unique numbers between 1 and 43
* then 1 extra number between 1 and 27 (meganumber) - does not need to be unique to the other 5 numbers
* Meganumber has a header of "MEGA"
* Print a header at the top of each ticket

* FORMATTING:
    ```
    > java SuperLotto 3

    #############################
    ###·CALIFORNIA·SUPERLOTTO·###
    #############################
    ·····························
    ························MEGA·
    ·A···01··25··30··35··40··25··
    ·B···03··19··21··33··41··04··
    ·C···05··15··21··34··35··18··
    ```

* SAMPLE:
    ```
    > java SuperLotto 14

    #############################
    ### CALIFORNIA SUPERLOTTO ###
    #############################

                            MEGA
     A   01  25  30  35  40  25
     B   03  19  21  33  41  04
     C   05  15  21  34  35  18
     D   01  25  30  35  40  25
     E   03  19  21  33  41  04
     F   05  15  21  34  35  18
     G   01  25  30  35  40  25
     H   03  19  21  33  41  04
     I   05  15  21  34  35  18
     J   01  25  30  35  40  25

    #############################
    ### CALIFORNIA SUPERLOTTO ###
    #############################

                            MEGA
     A   03  19  21  33  41  04
     B   05  15  21  34  35  18
     C   01  25  30  35  40  25
     D   03  19  21  33  41  04
    ```

* `.leftPadZero()`
* `.sort()`
* `.getRandom()`
* `.getUniqueRandoms`
* `.printTicket()`

```java
public static String leftPadZero(int num)
{
    return ((num < 10) ? "0" : "") + num;
}
```
