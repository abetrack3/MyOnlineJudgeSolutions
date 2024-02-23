import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            String s = "";
            if(n == 0)
            {
                System.out.println("0");
                continue;
            }
            else if(n == 1)
            {
                System.out.println("1");
                continue;
            }
            else
            {
                for(int i = 9; i>1; i--)
                {
                    if(n%i==0)
                    {
                        s = i + s;
                        n /= i;
                        i++;
                    }
                }
                if(n != 1)
                    System.out.println("-1");
                else
                    System.out.println(s);
            }
        }
    }
}