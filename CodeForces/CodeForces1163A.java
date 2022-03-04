import java.util.Scanner;
public class CodeForces1163A 
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int a=puttingvaluesinside.nextInt();
        int b=puttingvaluesinside.nextInt();
        if(b==0)
        {
        	System.out.println(1);
        	return;
        }
        a-=b;
        System.out.println((int)Math.min(a, b));
    }
}
