import java.util.*;

public class DemoProperties
{
    public static void printOS ()
    {
        String os = System.getProperty("os.name");
        System.out.println("Raw Output: " + os);

        if (os.toUpperCase().contains("LINUX"))
        {
            System.out.println("Operating system is Linux");
        }
        else if (os.toUpperCase().contains("WINDOWS"))
        {
            System.out.println("Operating system is Windows");
        }
        else if (os.toUpperCase().contains("MAC"))
        {
            System.out.println("Operating system is Mac");
        }
    }

    public static void main (String ... args)
    {
        printOS();
        System.out.println();

        System.out.println("java.vendor: " + System.getProperty("java.vendor"));
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("os.name: " + System.getProperty("os.name"));
        System.out.println("os.arch: " + System.getProperty("os.arch")); // architecture
        // MAC, LINUX, UNIX: `:`   WINDOWS: `;`
        System.out.println("path.separator: " + System.getProperty("path.separator"));
        System.out.println("user.dir: " + System.getProperty("user.dir")); // pwd
        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("user.name: " + System.getProperty("user.name"));
        System.out.println();

        System.setProperty("myName", "Ravi");

        Properties p = System.getProperties();
        p.list(System.out);
    }
}
