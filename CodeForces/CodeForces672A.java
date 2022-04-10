import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        String s="";
        int i=0;
        while(i++<=1000)
            s+=i;
        System.out.println(s.charAt(puttingvaluesinside.nextInt()-1));
    }
}