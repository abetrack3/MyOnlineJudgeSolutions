import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        while(puttingvaluesinside.hasNextLong())
        {
            long a=puttingvaluesinside.nextLong();
            long b=puttingvaluesinside.nextLong();
            System.out.println((long)(Math.abs(a-b)));
        }
    }
}