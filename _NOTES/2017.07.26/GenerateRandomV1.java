// sacrifices space for speed

public class GenerateRandomV1
{
    public static void main(String ... args) {
        int[] num = new int[20];
        boolean[] isAlreadyCreated = new boolean[51];
        Arrays.fill(isAlreadyCreated, false);

        int n = 0;

        for(;;)
        {
            int randNum = rand(1, 50);

            if (isAlreadyCreated[randNum])
            {
                num[n] = randNum;
                isAlreadyCreated[randNum] = true;
                n++;
            }

            if (n >= 20) break;
        }
    }
}
