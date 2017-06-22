# [CS111B] 2017.06.20

**Chapter 7**

### Questions

1.

    **Q:** Is there a way to iterate over all the variables? (instead of setting `this.{height, width, depth} = {height, width, depth}`)

    **A:** asdf

2.

    **Q:** Are there any real world use cases to just create an alias for an object? (`obj1 = obj2`)

    **A:** Only if you are not in control of creating the objects, but want to assign a meaningful name.

### To print output of terminal: `script`

```bash
script [filename];  # start log
cat Box.java;       # display Box source code
cat DemoBox.java;   # display DemoBox source code
javac Box.java;     # compile Box code
javac DemoBox.java; # compile DemoBox code
java DemoBox;       # run code
exit;               # end log
lp -d cclpr1 hw1;   # print log (to hills printer `cclpr1`)
rm hw1;             # delete log file
```

```
NAME
     script - make record of a terminal session

SYNOPSIS
     script [ -a ] [ filename ]

DESCRIPTION
     script makes a record of everything printed on your  screen.
     The  record  is  written  to  filename.   If no file name is
     given, the record is saved in the file 'typescript'.

     The script command forks and creates a sub-shell,  according
     to  the value of $SHELL, and records the text from this ses-
     sion.  The script ends when the forked shell exits  or  when
     CTRL-D is typed.

OPTIONS
     -a   Append the session record to filename, rather than
          overwrite it.
```

### Return codes

* `0` is success; anything greater is an error
* to see what the return code was for the last command run, run `echo $?`
* to return with a code, run `System.exit();` passing in the numbers

### Data Types

* in Ruby, data types are objects
* Java does not have any objects for data types
* Types
    * Primatives
        * long  (from +9,223,372,036,854,775,807 to -9,223,372,036,854,775,808)
        * int   (from             +2,147,483,647 to             -2,147,483,648)
        * short (from                    +32,767 to                    -32,768)
        * byte  (from                       +127 to                       -128)

        * double (from 1.797,693,134,862,315,7 E+308 to 4.9 E-324)
        * float  (from 3.402,823,5             E+38  to 1.4 E-45 )

        * char (single Unicode character, either 'A' or 65)

        * boolean (true/false)

        * void

    * String
* to parse out integers from Strings, use `Integer.parseInt(string)`

### ARGS

* `args` is responsible for getting all the data items passed at the command-line level; returns them as an array
* data is part of the command-line command:
    * `> java Delete file1 file2 file3`
    * `> java Sum 2 5 3 8 1`
* any command-line command consists of two parts:
    * command
    * data
* the first thing any program does is to perform **command-line validation** (checking if there is data provided)
* if data is missing, error message to user and terminate program using `System.exit(1);`

    ```java
        public static void die(String errorMessage)
        {
            System.err.println(errorMessage);
            System.exit(1); // 1 is the error code; 0 is SUCCESS
        }

        // NOTE: Java does not coerce numbers into booleans as JavaScript does
        if (args.length == 0) die("USAGE: `java ShowName [name1, name2, ...]`");

        // CODE HERE
    ```

* [see `Sum.java`]

### `main`

* an entry point/gateway into your program
* `public` - this method will be invoked by your JVM (`java` command); if it were private, JVM couldn't call it
* `static` - be directly available without an instance (don't want a class method)
* `void` - don't return anything
* `String ... args` - array of `String`s named `args`

```java
// XXX.java
class XXX
{
    public static void main(String ... args)
    {

    }
}
```

### Passing Data to Method

1. Pass by value: whatever change you make will not affect the original
    * variables

2. Pass by reference/address: whatever change you make will change the original
    * objects

* [see `DoubleIt.java`]
