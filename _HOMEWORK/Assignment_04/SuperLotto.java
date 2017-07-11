/**
 * This program emulates the California SuperLotto PLUS(R) Quick Pick(R)
 * functionality. Each ticket contains a maximum of 10 lines. Remaining lines
 * will overflow into as many additional tickets as needed. Each line of numbers
 * contains 5 unique numbers between 1 and 43 (printed in ascending order with
 * leading zeroes) and a sixth "Meganumber," a number between 1 and 27 which
 * does not need to be unique from the other numbers. Each line is alpha
 * enumerated with uppercase letters from A to J (correlating to 1 to 10).
 * The mega column is headed with the word "MEGA" and there should be a header
 * at the top of each ticket.
 *
 * Here is a sample call to the program:
 *
 *     > java SuperLotto 14
 *
 *     #############################
 *     ### CALIFORNIA SUPERLOTTO ###
 *     #############################
 *
 *                             MEGA
 *      A   06  14  24  28  43  12
 *      B   08  11  18  31  36  15
 *      C   14  18  33  41  42  21
 *      D   07  19  30  38  39  26
 *      E   07  08  19  32  41  26
 *      F   09  14  16  19  41  24
 *      G   03  09  24  28  37  05
 *      H   08  09  14  24  30  10
 *      I   03  17  37  39  42  17
 *      J   08  12  14  23  41  13
 *
 *
 *     #############################
 *     ### CALIFORNIA SUPERLOTTO ###
 *     #############################
 *
 *                             MEGA
 *      A   17  18  23  32  37  02
 *      B   02  12  19  24  42  07
 *      C   01  07  09  11  31  02
 *      D   01  06  15  26  32  15
 *
 * @name    SuperLotto
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.07.10
 * @version 1.0
 */

import java.util.*;

public class SuperLotto
{
    /**
     * This is a die method that prints a message to the stderr stream and
     * exits the program with an error code.
     *
     * @param errorMessage The error message to be displayed to users
     */
    private static void die(String errorMessage)
    {
        System.err.println(errorMessage);
        System.exit(1);
    }

    /**
     * This method repeats a character at the beginning of a String, padding the
     * String until it reaches a desired width.
     *
     * @param  input  The String to be padded
     * @param  width  An integer for the desired final width of the String
     * @param  padder The character to be repeated to go get to final width
     * @return String The final padded String
     */
    private static String leftPad (String input, int width, char padder)
    {
        // cache number of characters in input
        int inputWidth = input.length();

        // if user desires a width shorter than input width, return unchanged
        if (inputWidth >= width) return input;

        // initialize a StringBuilder with capacity set to desired width
        StringBuilder output = new StringBuilder(width);

        // repeat characters to fill missing width
        for (int i = 0; i < (width - inputWidth); i++)
        {
            output.append(padder);
        }

        // append original input to end of repeated characters and return String
        return output.append(input).toString();
    }

    /**
     * This method converts an integer into a String and then repeats a
     * character at the beginning of the String until it reaches a desired
     * width.
     *
     * @param  input  The integer to be padded
     * @param  width  An integer for the desired final width of the String
     * @param  padder The character to be repeated to go get to final width
     * @return String The final padded string
     */
    private static String leftPad (int input, int width, char padder)
    {
        return leftPad("" + input, width, padder);
    }

    /**
     * This method returns a random integer between the provided lower limit
     * and upper limit.
     *
     * @param  a   An int representing the lower limit (inclusive)
     * @param  b   An int representing the upper limit (inclusive)
     * @return int A random number between the two limits
     */
    private static int getRandomNumber(int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }

    /**
     * This method iterates through an array searching for a target number and
     * returns a boolean if it is/is not found. It performs sequential search,
     * but it only searchs over elements that have already been populated
     * (represented by the `limit` param).
     *
     * @param  set     An array of integers to check against
     * @param  target  The integer that is being searched for
     * @param  limit   The last index that has already been populated
     * @return boolean A boolean for if the number already exists in the set
     */
    private static boolean isRepeated(int[] set, int target, int limit)
    {
        for (int i = 0; i < limit + 1; i++)
        {
            if (target == set[i]) return true;
        }

        return false;
    }

    /**
     * This method generates an array of given number of random integers between
     * the lower and upper limits provided and returns the array.
     *
     * @param  count The number of numbers that should be generated
     * @param  lower An int representing the lower limit
     * @param  upper An int representing the upper limit
     * @return int[] An array of integers that were generated
     */
    private static int[] getUniqueNumbers(int count, int lower, int upper)
    {
        int[] numbers = new int[count];

        for (int i = 0; i < numbers.length; i++)
        {
            int randomNumber = getRandomNumber(lower, upper);
            while (isRepeated(numbers, randomNumber, i))
            {
                randomNumber = getRandomNumber(lower, upper);
            }
            numbers[i] = randomNumber;
        }

        return numbers;
    }

    /**
     * This method accepts an array of lines where each element is itself
     * an array of integers and formats the output to resemble a
     * California SuperLotto PLUS(R) Quick Pick(R) tickets.
     *
     * NOTE: This method does NOT validate input format or sanitize the data
     *       in any way. The user must do this before invoking this function.
     *
     * @param lines An array of lines (a line being an array of integers)
     */
    private static void printTicket (int[][] lines)
    {
        System.out.println();
        System.out.println("#############################");
        System.out.println("### CALIFORNIA SUPERLOTTO ###");
        System.out.println("#############################");
        System.out.println();
        System.out.println("                        MEGA ");

        // iterate over lines
        for (int i = 0; i < lines.length; i++)
        {
            System.out.print(" " + String.valueOf((char)(i + 65)) + "   ");

            // iterate over numbers
            for (int j = 0; j < lines[i].length; j++)
            {
                System.out.print(leftPad(lines[i][j], 2, '0') + "  ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * This method generates a California SuperLotto PLUS(R) Quick Pick(R) line.
     * Each line contains 5 unique numbers between 1 and 43 and a sixth
     * "Meganumber," a number between 1 and 27 which does not need to be unique
     * from the other numbers.
     *
     * @return int[] An array of integers representing a Quick Pick(R) line
     */
    private static int[] generateLine ()
    {
        int[] line = new int[6];
        int[] numbers = getUniqueNumbers(5, 1, 43);
        int meganumber = getRandomNumber(1, 27);

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) line[i] = numbers[i];
        line[5] = meganumber;

        return line;
    }

    /**
     * This method takes a desired number of lines and generates a
     * California SuperLotto PLUS(R) Quick Pick(R) ticket (where each ticket
     * can only have a maximum of 10 lines).
     *
     * NOTE: This method does NOT validate input format or sanitize the data
     *       in any way. The user must do this before invoking this function.
     *
     * @param numOfLines The number of lines to generate a ticket for
     * @return int[][][] An array of lines (which are arrays of integers)
     */
    private static int[][] generateTicket (int numOfLines)
    {
        int[][] ticket = new int[numOfLines][6];

        for (int i = 0; i < numOfLines; i++)
        {
            ticket[i] = generateLine();
        }

        return ticket;
    }

    /**
     * This method takes a number to chunk and the chunk size and returns an
     * array of integers representing the chunks.
     *
     * For example, `generateChunks(41, 10)` returns `{ 10, 10, 10, 10, 1 }`
     *
     * @param  totalNum  The total number that is to be chunked
     * @param  chunkSize The integer size of each chunk
     * @return int[]     An array of integers representing the chunks
     */
    private static int[] generateChunks (int totalNum, int chunkSize)
    {
        if (totalNum < 1 || chunkSize < 1) return new int[] {};
        if (totalNum <= chunkSize) return new int[] { totalNum };

        int numOfChunks      = totalNum / chunkSize;
        int partialChunkSize = totalNum % chunkSize;

        boolean hasPartialChunk = partialChunkSize != 0;

        if (hasPartialChunk) numOfChunks++;

        int[] chunks = new int[numOfChunks];

        Arrays.fill(chunks, chunkSize);

        if (hasPartialChunk) chunks[numOfChunks - 1] = partialChunkSize;

        return chunks;
    }

    /**
     * This method accepts a desired number of lines and then generates tickets
     * (an array of lines where each element is itself an array of integers)
     * and prints each ticket out to the user.
     *
     * @param numOfLines The number of lines to generate and print tickets for
     */
    private static void printTickets (int numOfLines)
    {
        int[] ticketChunkSizes = generateChunks(numOfLines, 10);

        for (int size : ticketChunkSizes)
        {
            int[][] ticket = generateTicket(size);
            printTicket(ticket);
        }
    }

    /**
     * This is the `main` method of this class. It validates arguments passed
     * in and then prints (a) ticket(s) containing the desired number of lines.
     *
     * @param array An array of arguments provided to the program
     */
    public static void main (String ... args)
    {
        if (args.length == 0) die("Missing argument!");
        if (args.length > 1) die("Too many arguments!");

        try
        {
            int numOfLines = Integer.parseInt(args[0]);

            if (numOfLines < 1) die("Invalid number of lines!");

            printTickets(numOfLines);
        }
        catch (NumberFormatException e)
        {
            die("Invalid argument!");
        }
    }
}
