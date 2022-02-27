import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        String a=puttingvaluesinside.nextLine();
        String b=puttingvaluesinside.nextLine();
        int n=a.toUpperCase().compareTo(b.toUpperCase());
        if(n==0)
            System.out.println(0);
        else if(n>0)
            System.out.println(1);
        else
            System.out.println(-1);
    }
}