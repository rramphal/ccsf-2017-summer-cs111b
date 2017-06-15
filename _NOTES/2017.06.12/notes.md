# [CS111B] 2017.06.12

### Logistics

* 19:10-21:30 MTWR
* textbook: *Java: The Complete Reference (9ed)* (Java 8)
* main computer system: `hills` (runs on Linux) - always accessible
* solutions, samples, exams, announcements, data files, etc. will be placed in public directory
* no midterm during summer courses
* learn Linux
* grades are found on the computer
* A (90-100), B (80-90), C (70-80)
* all programs must be documented:
    * ```java
        /*
         * AUTHOR    : Ravi S. Rāmphal
         * DATE      : (date completed)
         * COURSE    : CS111B
         * OBJECTIVE : (description)
         */
      ```
    * do not add copyright information
* all homework must be printed and handed in:
    1. source code
    2. sample of output
* line length limit: 66 characters
* NEVER use the TAB character, use 4 spaces - some printers strip them and some mail handlers convert them to ASCII
* we use Allman style in this class:
    * K&R style: (old, problematic, obsolete)
        ```java
            if (...) {
                //
            }
        ```

    * Allman style:
        ```java
            if (...)
            {
                //
            }
        ```
* text editors: vi, vim, emacs, nano, pico
* when installing Java, you might need to set up the right environment variables

### Java

* cross-platform
* there is bash for Windows
* March 2000 - Abbas' company (Linuxicon)
* `javac` to compile
* `java` to run
* invented in 1994 by Sun Microsystems to control home devices
* save --> compile --> run
    * `javac Hello.java` ==> spits out `Hello.class`
    * `java Hello`
* `javac` converts to bytecode
* "compile on one machine, run everywhere"
* main in the most important class
* `print` - same line
* `println` - next line
* internally, all floats are converted to doubles; to avoid the calculations, just use `double`

### OOP
* OOP language - everything should be object-oriented
* in Java, everything is a class
* a class is a container where you define variables and create methods
* classes are capitalized (See `Hello.java`)
* classes are stored in their own files with the same name as the name of the class

### Example

[See `Calc.java`]
