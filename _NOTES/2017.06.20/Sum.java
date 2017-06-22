/*
 * INPUT: `> java Sum 2 5 3 8`
 * OUTPUT: display sum
 */

class Sum
{
    public static void die(String errorMessage)
    {
        System.out.println(errorMessage);
        System.exit(1);
    }

    public static void main(String ... args)
    {
        if (args.length == 0) die("USAGE: `java Sum [num1, num2, ...]`");

        int sum = 0;
        for (String num : args) sum += Integer.parseInt(num);
        System.out.println("sum = " + sum);
    }
}
