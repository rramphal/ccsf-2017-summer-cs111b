class PassByRef
{
    public static void doubleIt(int ... num)
    {
        num[0] = num[0] * 2;
    }

    public static void main(String ... args)
    {
        int[] n = {7};
        System.out.println("before: " + n[0]);
        doubleIt(n);
        System.out.println("after: " + n[0]); // value actually changes
    }
}
