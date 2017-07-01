# [CS111B] 2017.06.29

**Chapters 9 & 10**

### Packages

* **packages** are a way to contain one or more (COMPILED) classes/interfaces
* at the beginning of the file, use the keyword `package` followed by the name in LOWERCASE
    ```java
    // A.java
    package com.example;

    public class A
    {
        // ...
    }

    // B.java
    package com.example;

    public class B
    {
        // ...
    }
    ```
* to compile
    ```bash
    javac -d [directory] [filename]
    ```
* if you leave out `-d .`, it will generate the class files in the same folder as the Java executable files
* you then put your package into a `.jar` file to share (compressed)
* if you would like to place your source code in the same directory, use `-s`
* Java's naming convention: should be in the format of a reverse domain: `com.example` - to be a unique name; HOWEVER Abbas doesn't follow it and simply uses short package names
* only one package is accessible by default: `java.lang.*`
* to use package:
    ```java
    // import java.util.[className];
    import java.util.*;
    ```
* using `*` instead of the specific classes is totally okay because using the specific name has no benefits
* there are two ways to import custom packages:
    * setting the CLASSPATH envvar in your startup file (`.bash_profile`, `.bashrc`, `.profile`)
        * `.bash_profile` - for making sure that both the things in `.profile` and `.bashrc` are loaded for login shells
        * `.bashrc` - for the configuring the interactive Bash usage, like Bash aliases, setting your favorite editor, setting the Bash prompt, etc.
        * `.profile` - for things that are not specifically related to Bash
        * don't forget to add `:.` at the end of `CLASSPATH`
            ```bash
            CLASSPATH="..."
            ```
    * passing an option into `javac`
        * `javac -cp ... [filename]`

### Error Handling

* **syntax error** / **compiler error** - errors in syntax (before execution)
* **runtime error** / **exception** - errors which come up while running (during execution)
* you need to **handle** exceptions
* `Exception` is an object
* when any runtime error happens, Java immediately creates an Exception which has a name specific to the error and **throws** it to your program
* "if you don't catch the error that is thrown to your program, it will hit your program and crash your program"

```java
int a = Integer.parseInt(getString("Give me a number: "));
int b = Integer.parseInt(getString("Give me another number: "));
int c = a / b; // this protentially results in a division by zero error
System.out.println("c = " + c);
```

```java
try
{
    int a = Integer.parseInt(getString("Give me a number: "));
    int b = Integer.parseInt(getString("Give me another number: "));
    int c = a / b; // this protentially results in a division by zero error
    System.out.println("c = " + c);
}
catch (ArithmeticException e)
{
    System.err.println("Please do not divide by zero.");
    System.err.println(e);
}

// this protentially results in a division by zero error
```
* before Java 7, you had to write a catch block for every single Exception; after Java 7, you could use the OR operator (`||`)
* when you catch an exception, nothing will be interrupted and nothing will be stopped

```java
try
{
    int[] num = new int[10];
    for (int i = 0; i <= 10; i++) // array index out of bounds
    {
        num[i] = i * 2;
    }
}
catch (ArrayIndexOutOfBoundsException e) {} // Microsoft style: HF (hide and freeze)
```

### Error Hierarchy

* we can't fix `Error`s
* you can use `Exception` when you don't know the specific error

* **Throwable**:
    * **Exception**: The appropriate subclass of this exception is thrown in response to an error detected at the virtual machine level. If a program defines its own exception classes, they should be subclasses of the Exception class.
        * **ClassNotFoundException**: This exception is thrown to indicate that a class that is to be loaded cannot be found.
        * **CloneNotSupportedException**: This exception is thrown when the clone() method has been called for an object that does not implement the Cloneable interface and thus cannot be cloned.
        * **IllegalAccessException**: This exception is thrown when a program tries to dynamically load a class (i.e., uses the forName() method of the Class class, or the findSystemClass() or the loadClass() method of the ClassLoader class) and the currently executing method does not have access to the specified class because it is in another package and not public. This exception is also thrown when a program tries to create an instance of a class (i.e., uses the newInstance() method of the Class class) that does not have a zero-argument constructor accessible to the caller.
        * **InstantiationException**: This exception is thrown in response to an attempt to instantiate an abstract class or an interface using the newInstance() method of the Class class.
        * **InterruptedException**: This exception is thrown to signal that a thread that is sleeping, waiting, or otherwise paused has been interrupted by another thread.
        * **NoSuchMethodException**: This exception is thrown when a specified method cannot be found.
        * **RuntimeError**: The appropriate subclass of this exception is thrown in response to a runtime error detected at the virtual machine level. Because these exceptions are so common, methods that can throw objects that are instances of RuntimeException or one of its subclasses are not required to declare that fact in their throws clauses.
            * **ArithmeticException**: This exception is thrown to indicate an exceptional arithmetic condition, such as integer division by zero.
            * **ArrayStoreException**: This exception is thrown when there is an attempt to store a value in an array element that is incompatible with the type of the array.
            * **ClassCastException**: This exception is thrown when there is an attempt to cast a reference to an object to an inappropriate type.
            * **IllegalArgumentException**: This exception is thrown to indicate that an illegal argument has been passed to a method.
                * **IllegalThreadStateException**: This exception is thrown to indicate an attempt to perform an operation on a thread that is not legal for the thread's current state, such as attempting to resume a dead thread.
                * **NumberFormatException**: This exception is thrown to indicate that an attempt to parse numeric information in a string has failed.
            * **IllegalMonitorStateException**: This exception is thrown when an object's wait(), notify(), or notifyAll() method is called from a thread that does not own the object's monitor.
            * **IndexOutOfBoundsException**: The appropriate subclass of this exception (i.e., ArrayIndexOutOfBoundsException or StringIndexOutOfBoundsException) is thrown when an array or string index is out of bounds.
                * **ArrayIndexOutOfBoundsException**: This exception is thrown when an out-of-range index is detected by an array object. An out-of-range index occurs when the index is less than zero or greater than or equal to the size of the array.
                * **StringIndexOUtOfBoundsException**: This exception is thrown when a String or StringBuffer object detects an out-of-range index. An out-of-range index occurs when the index is less than zero or greater than or equal to the length of the string.
            * **NegativeArraySizeException**: This exception is thrown in response to an attempt to create an array with a negative size.
            * **NullPointerException**: This exception is thrown when there is an attempt to access an object through a null object reference. This can occur when there is an attempt to access an instance variable or call a method through a null object or when there is an attempt to subscript an array with a null object.
            * **SecurityException**: This exception is thrown in response to an attempt to perform an operation that violates the security policy implemented by the installed SecurityManager object.
    * **Error**: The appropriate subclass of this error is thrown when an unpredictable error, such as running out of memory, occurs. Because of the unpredictable nature of these errors, methods that can throw objects that are instances of Error or one of its subclasses are not required to declare that fact in their throws clauses.
        * **LinkageError**: The appropriate subclass of this error is thrown when there is a problem resolving a reference to a class. Reasons for this may include a difficulty in finding the definition of the class or an incompatibility between the current definition and the expected definition of the class.
            * **ClassCircularityError**: This error is thrown when a circular reference among classes is detected during class initialization.
            * **ClassFormatError**: This error is thrown when an error is detected in the format of a file that contains a class definition.
            * **IncompatibleClassChangeError**: This error or one of its subclasses is thrown when a class refers to another class in an incompatible way. This situation occurs when the current definition of the referenced class is incompatible with the definition of the class that was found when the referring class was compiled. For example, say class A refers to a method in class B. Then, after class A is compiled, the method is removed from class B. When class A is loaded, the run-time system discovers that the method in class B no longer exists and throws an error.
                * **AbstractMethodError**: This error is thrown in response to an attempt to invoke an abstract method.
                * **IllegalAccessError**: This error is thrown when a class attempts to access a field or call a method it does not have access to. Usually this error is caught by the compiler; this error can occur at run-time if the definition of a class changes after the class that references it was last compiled.
                * **InstantiationError**: This error is thrown in response to an attempt to instantiate an abstract class or an interface. Usually this error is caught by the compiler; this error can occur at run-time if the definition of a class is changed after the class that references it was last compiled.
                * **NoSuchFieldError**: This error is thrown in response to an attempt to reference an instance or class variable that is not defined in the current definition of a class. Usually this error is caught by the compiler; this error can occur at run-time if the definition of a class is changed after the class that references it was last compiled.
                * **NoSuchMethodError**: This error is thrown in response to an attempt to reference a method that is not defined in the current definition of a class. Usually this error is caught by the compiler; this error can occur at run-time if the definition of a class is changed after the class that references it was last compiled.
            * **NoClassDefFoundError**: This error is thrown when the definition of a class cannot be found.
            * **UnsatisfiedLinkError**: This error is thrown when the implementation of a native method cannot be found.
            * **VerifyError**: This error is thrown when the byte-code verifier detects that a class file, though well-formed, contains some sort of internal inconsistency or security problem.
        * **ThreadDeath**: This error is thrown by the stop() method of a Thread object to kill the thread. Catching ThreadDeath objects is not recommended. If it is necessary to catch a ThreadDeath object, it is important to re-throw the object so that it is possible to cleanly stop the catching thread.
        * **VirtualMachineError**: The appropriate subclass of this error is thrown to indicate that the Java virtual machine has encountered an error.
            * **InternalError**: This error is thrown to signal an internal error within the virtual machine.
            * **OutOfMemoryError**: This error is thrown when an attempt to allocate memory fails.
            * **StackOverflowError**: This error is thrown when a stack overflow error occurs within the virtual machine.
            * **UnknownError**: This error is thrown when an error of unknown origins is detected in the run-time system.
        * **AWTError**

### Homework Assignment 03

* Abbas has made a data file called `datafile` on `hills`
* copy header lines
* swap `firstname,lastname` to `lastname,firstname`
* ensure same number of lines
* save in a file called `datafile.fix`
* open file, read record after record, if each begins with a pound sign, it is a header; otherwise, the line should be modified
* provide `source code`, `datafile`, `datafile.fix`
