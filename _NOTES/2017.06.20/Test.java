import java.util.Arrays;

class Test
{
    public static void die(String errorMessage)
    {
        System.err.println(errorMessage);
        System.exit(1);
    }

    public static void main(String ... args)
    {
        if (args.length == 0) die("USAGE: `java Test [DATA]`");

        System.out.println(Arrays.toString(args));
        for(String arg : args) System.out.println(arg);
    }
}
