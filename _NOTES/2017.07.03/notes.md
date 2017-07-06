# [CS111B] 2017.07.03

FB Pages: CS211S, CS211E, CS211D, CS311D

### Reading / Writing to Files

* a *file* is an collection of characters organized based on some system
    * *text file*
        * consists of lines (**records**)
        * terminates each line with either `\n` (`^J` in caret notation) (*nix) or `\r\n` (`^M^J`) (Windows)
    * *binary file* -
    * in (*nix), there are also system files:
        * directories
        * hardware
* there is a class `File` in Java
* `File(String absolutePath)`
* `File(String directory, String filename)`
* `boolean [File].canRead()`
* `boolean [File].canWrite()`
* `boolean [File].canExecute()`
* `boolean [File].isDirectory()`
* `boolean [File].isFile()`
* `boolean [File].exists()`
* `boolean [File].delete()`
* `boolean [File].close()`
* `boolean [File].deleteOnExit()` - deleted on program exit
* `boolean [File].mkdir(String dirName)`
* `boolean [File].mkdirs(String dirName)` - creates intermediate directories if they are missing (analagous to `mkdir -p` to created any nested directories that are missing)
* `long [File].lastModified()`
* `long [File].length()`
* you need to **open** a file to:
    * **read**
    * **write** - will overwrite an existing file
    * **append** - will not overwrite and will instead add to the end of a file
* In *nix, the shortest way to clear a file is to use `> filename`
* You can use `Scanner` to read files (scanner always opens for read)

### Time

* time is stored relative to the number of milliseconds since Jan 1, 1970 (**Unix time** / **POSIX time** / **epoch time**)
* Unix Millennium Bug (03:14:07 UTC on 19 January 2038)

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
        if (// doesn't exist and if it does, make sure you can write AND that it is empty)
        PrintWriter printWriter = new PrintWriter("datafix.fix");
        printWriter.println(line);
        printWriter.close();
    }

    public static void main (String ... args) throws IOException
    {

    }
}
```

"Sometimes if you write to an existing file, the contents of the file is gone. And sometimes, if you write to an existing file, your /job/ is gone."
