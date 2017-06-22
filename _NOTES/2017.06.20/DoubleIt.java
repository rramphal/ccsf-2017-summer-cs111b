/*
 * INPUT: `> java DoubleIt 2`
 * OUTPUT: double the number provided
 */

class X
{
    public static int num;
}

class DoubleIt
{
    public static void doubleIt(class X)
    {
        X.num = X.num * 2;
        System.out.println("inside: " + X.num);
    }

    public static void main(String ... args)
    {
        X.num = 7;
        System.out.println("before: " + X.num);
        doubleInt(X);
        System.out.println("after: " + X.num);
    }
}
