import java.util.*;

public class DemoCalendar
{
    public static void main(String ... args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Month:"         + calendar.get(Calendar.MONTH)       );
        System.out.println("Day: "          + calendar.get(Calendar.DATE)        ); // day
        System.out.println("Day of Month: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of Week: "  + calendar.get(Calendar.DAY_OF_WEEK) );
    }
}
