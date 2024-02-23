import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        while(true)
        {
            String x=puttingvaluesinside.nextLine();
            if(x.equals("DONE"))
                break;
            char []c=x.toCharArray();
            String s1="", s2="";
            for(int i=0, j=c.length-1;i<c.length;i++, j--)
            {
                if(((c[i]>='a')&&(c[i]<='z'))||((c[i]>='A')&&(c[i]<='Z')))
                    s1+=c[i];
                if(((c[j]>='a')&&(c[j]<='z'))||((c[j]>='A')&&(c[j]<='Z')))
                    s2+=c[j];
            }
            if(s1.toUpperCase().equals(s2.toUpperCase()))
                System.out.println("You won't be eaten!");
            else
                System.out.println("Uh oh..");
        }
    }
}