import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        char [] c=puttingvaluesinside.nextLine().toCharArray();
        if(c.length==0)
            System.out.println(0);
        else
        {
            int count=1;
            for(char x:c)
                if(x>=65&&x<=90) count++;
            System.out.println(count);
        }
    }
}