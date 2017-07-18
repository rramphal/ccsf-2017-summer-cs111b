import java.awt.*;

public class ShowFonts
{
    public static void main (String ... args)
    {
        String[] fontList;

        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

        fontList = ge.getAvailableFontFamilyNames();

        System.out.println(fontList.length + " fonts:");

        for (String font : fontList)
        {
            System.out.println("    * " + font);
        }
    }
}
