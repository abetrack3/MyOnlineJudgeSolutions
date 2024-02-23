//Problem E
//UVA 12372
import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int a=1;a<=t;a++)
        {
            int x=puttingvaluesinside.nextInt(),
                y=puttingvaluesinside.nextInt(),
                z=puttingvaluesinside.nextInt();
            if((x<=20)&&(y<=20)&&(z<=20))
                System.out.println("Case "+a+": good");
            else
                System.out.println("Case "+a+": bad");
        }
    }
}