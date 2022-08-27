import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int a=1;a<=t;a++)
        {
            puttingvaluesinside.nextLine();
            int s=0;
            for(int b=puttingvaluesinside.nextInt();b>0;b--)
            {
                int c=puttingvaluesinside.nextInt();
                if(c>0) s+=c;
            }
            System.out.println("Case "+a+": "+s);
        }
    }
}