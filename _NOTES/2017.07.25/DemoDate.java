import java.util.*;

public class DemoDate
{
    public static int getMinute ()
    {
        String date = (new Date()).toString();
        String[] parts = date.split(":");
        return Integer.parseInt(parts[1]);
    }

    public static int getSecond ()
    {
        String date = (new Date()).toString();
        String[] parts = date.split(":");
        // String[] parts2 = parts[2].split(" ");
        // return Integer.parseInt(parts2[0]);
        return Integer.parseInt(parts[2].substring(0, 2));
    }

    public static void main(String ... args) {
        Date d = new Date();
        System.out.println("date:   " + d);

        // Tue Jul 25 20:42:51 PDT 2017
        // Weekday
        //     Month
        //         Day
        //            Hour
        //               Minute
        //                  Second
        //                     Timezone: PDT - Daylight; PST - Standard
        //                         Year

        System.out.println("minute: " + getMinute());
        System.out.println("second: " + getSecond());
    }
}
