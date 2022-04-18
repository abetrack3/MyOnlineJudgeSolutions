import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=puttingvaluesinside.nextInt();
        if(n==1)
        {
            if(puttingvaluesinside.nextInt()==1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else
        {
            int count=0;
            while(n-->0)
            {
                if(puttingvaluesinside.nextInt()==0)
                    count++;
            }
            if(count==1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}