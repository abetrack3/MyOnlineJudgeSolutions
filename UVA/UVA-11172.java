import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int a=puttingvaluesinside.nextInt();a>0;a--)
        {
            int b=puttingvaluesinside.nextInt();
            int c=puttingvaluesinside.nextInt();
            if(b==c)
                System.out.println("=");
            else if(b>c)
                System.out.println(">");
            else
                System.out.println("<");
        }
    }
}