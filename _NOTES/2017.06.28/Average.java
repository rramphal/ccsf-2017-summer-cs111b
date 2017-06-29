class Average
{
    public static double avg(double ... d)
    {
        double sum = 0.0;

        for(double num : d) sum += num;

        return (d.length == 0) ? 0 : sum / d.length;
    }

    public static void main(String ... args)
    {
        System.out.println("average = " + avg(1, 5, 3));
        // System.out.println("average = " + avg(double[] {5, 9, 7, 2}));
        System.out.println("average = " + avg());
    }
}
