import java.io.*;
import java.util.*;

public class NameSwapper
{
    private static void die(String message)
    {
        System.err.println(errorMessage);
        System.exit(1);
    }

    public static File validateInput(String filename)
    {
        if (filename.length() < 1) die("Input filename not provided!");

        File file = new File(filename);

        if (!file.exists())      die(filename + " does not exist!");
        if (!file.isFile())      die(filename + " is not a file!");
        if ( file.isDirectory()) die(filename + " is a directory!");
        if (!file.canRead())     die(filename + " cannot be read!");

        return file;
    }

    public static File createOutput(String filename)
    {
        if (filename.length() < 1) die("Output filename not provided!");

        File file = new File(filename);

        if (file.exists()) die(filename + " already exists!");

        try
        {
            file.createNewFile();

            if (!file.canWrite()) die(filename + " cannot be written to!");
        }
        catch (IOException e)
        {
            System.err.println(filename + " could not be created!");
        }

        return file;
    }

    public static boolean isHeader(String line)
    {
        if (line.length() == 0) return false;
        if (line.charAt(0) == '#') return true;
        return false;
    }

    public static String processLine(String line)
    {
        if (isHeader(line)) return line;          // do not change header
        if (line.indexOf(",") == -1) return line; // only change comma lines

        String[] parts = line.split(",");

        if (parts.length > 2) return line;        // too many parts to process

        return parts[1] + ", " + parts[0];
    }

    public static void processFile(File inputFile, File outputFile)
    {
        try
        {
            Scanner     scanner     = new Scanner(inputFile);
            FileWriter  fileWriter  = new FileWriter(outputFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String line;

            while(scanner.hasNext())
            {
                line = scanner.nextLine();
                printWriter.println(processLine(line));
            }

            scanner.close();
            printWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Input file not found!");
        }
        catch (IOException e)
        {
            System.err.println("Output file not found!");
        }
    }

    public static void main (String ... args)
    {
        String input  = "datafile";
        String output = "datafile.fix";

        if (args.length == 2)
        {
            input  = args[0];
            output = args[1];
        }

        File inputFile  = validateInput(input);
        File outputFile = createOutput(output);

        processFile(inputFile, outputFile);
    }
}
