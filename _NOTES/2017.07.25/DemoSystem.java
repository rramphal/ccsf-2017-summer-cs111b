import java.util.*;

public class DemoSystem
{
       public static String[] system(String cmd)
       {
          ArrayList<String> al = new ArrayList<>();
          String shell = "/bin/bash", option = "-c";
          if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)
          {
             shell = "cmd"; option="/C";
          }
          String ar[] = {shell, option, cmd};

          try
          {
             Process p = (new ProcessBuilder(ar)).redirectErrorStream(true).start();
             Scanner sc = new Scanner(p.getInputStream());
             while(sc.hasNext()) al.add(sc.nextLine());
             sc.close();
          } catch(Exception e){System.err.println("commanmd error");}
          return(al.toArray(new String[al.size()]));
       }

       public static void main(String ... args) {
           String[] myFiles = system("ls");
           for(String f:myFiles) println(f);
           system("say 'Hello Abbas'");
       }
}
