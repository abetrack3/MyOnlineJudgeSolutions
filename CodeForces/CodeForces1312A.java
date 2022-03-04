import java.util.Scanner;
 
public class CodeForces1312A
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            int m = puttingvaluesinside.nextInt();
            System.out.println((n%m==0)?"YES":"NO");
        }
    }
}
