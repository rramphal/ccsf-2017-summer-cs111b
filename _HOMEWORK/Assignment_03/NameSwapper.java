/**
 * This class allows the user to process a datafile to fix incorrectly inputted
 * names. It assumes a file format where headers (which remain untouched) are
 * marked with pound signs at the beginning of the line. Blank lines are
 * maintained. The only lines which are changed are those containing names in
 * the format `firstname,lastname` which are then corrected to the format
 * `lastname, firstname`.
 *
 * The user can call the program WITHOUT command-line arguments which will
 * default to the input filename `datafile` and output filename `datafile.fix`.
 * The program can be modified in the future to get rid of hard-coded filenames
 * and instead ask for the filenames.
 *
 * The user can also call the program WITH command-line arguments where the
 * first is the name of the file that is to be processed and the second is that
 * of the file that is to be outputted to.
 *
 * NOTE: This program is not destructive and will die if the output file
 * already exists and will not overwrite files. It leaves the input file intact.
 *
 * @name    NameSwapper
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.07.06
 * @version 1.0
 */

import java.io.*;
import java.util.*;

public final class NameSwapper
{
    /**
     * This is a die method that prints a message to the stderr stream and
     * exits the program with an error code.
     *
     * @param  errorMessage  The error message to be displayed to users
     */
    private static void die(String errorMessage)
    {
        System.err.println(errorMessage);
        System.exit(1);
    }

    /**
     * This method validates the input file for the program to work with and
     * returns its `File` object. It will cause the program to die if:
     *     - the input name is not provided
     *     - the file does not exist exists
     *     - the file is not a file
     *     - the file is a directory
     *     - the file does exist and is a file, but cannot be read
     *
     * @param  filename  A string containing the name of the input file
     * @return File      The File object of the file with the name provided
     */
    private static File validateInput(String filename)
    {
        if (filename.length() < 1) die("Input filename not provided!");

        File file = new File(filename);

        if (!file.exists())      die(filename + " does not exist!");
        if (!file.isFile())      die(filename + " is not a file!");
        if ( file.isDirectory()) die(filename + " is a directory!");
        if (!file.canRead())     die(filename + " cannot be read!");

        return file;
    }

    /**
     * This method creates the output file for the program to work with and
     * returns its `File` object. It will cause the program to die if:
     *     - the output name is not provided
     *     - the file already exists
     *     - the file could not be created
     *     - the file could be created, but not written to
     *
     * @param  filename  A string containing the name of the desired output file
     * @return File      The File object of the file with the name provided
     */
    private static File createOutput(String filename)
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

    /**
     * The method checks whether or not the line is a header.
     * It defaults to `false` and will return `false` on an empty string.
     * Otherwise, if the line begins with a pound sign, it returns `true`.
     *
     * @param  line    The string containing the line to be processed
     * @return boolean A boolean value as to whether the line is a header or not
     */
    private static boolean isHeader(String line)
    {
        if (line.length() == 0) return false;
        if (line.charAt(0) == '#') return true;
        return false;
    }

    /**
     * This method is responsible for processing each line.
     *
     * The line is returned unmodified if:
     *     - it is a header
     *     - there are no commas
     *     - there is more than one comma
     *
     * Otherwise, the line is returned swapped with a comma and a space between.
     *
     * @param  line   The string containing the line to be processed
     * @return String The processed string
     */
    private static String processLine(String line)
    {
        if (isHeader(line)) return line;          // do not change header
        if (line.indexOf(",") == -1) return line; // only change comma lines

        String[] parts = line.split(",");

        if (parts.length > 2) return line;        // too many parts to process

        return parts[1] + ", " + parts[0];
    }

    /**
     * This method takes in the two files (already validated). Technically,
     * error handling is not necessary in this method since the input and
     * output files would have already been validated in the main method.
     *
     * A `Scanner` object is created to iterate over each line of the input file
     * and each line is processed and then written to the output file.
     *
     * @param inputFile  The File that is to be processed
     * @param outputFile The File that is to be outputted to
     */
    private static void processFile(File inputFile, File outputFile)
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

    /**
     * This is the `main` method of this class. It sets up default filenames
     * but also allows for names to be passed in through command-line arguments.
     * File validation is done here and then the file is processed.
     *
     * @param array An array of arguments provided to the program
     */
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
        System.out.println("File processed.");
    }
}
