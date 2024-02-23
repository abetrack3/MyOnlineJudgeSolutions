import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        while(puttingvaluesinside.hasNextLine())
        {
            String name1=puttingvaluesinside.nextLine();
            String name2=puttingvaluesinside.nextLine();
            int n1=stringToDigit(name1,true), n2=stringToDigit(name2, true);
            while(!((""+n1).length()==1))
                n1=stringToDigit(""+n1, false);
            while(!((""+n2).length()==1))
                n2=stringToDigit(""+n2, false);
            if(n1==n2)
            {
                System.out.println("100.00 %");
                continue;
            }
            if(n1==0||n2==0)
            {
                System.out.println("00.00 %");
                continue;
            }
            if(n1>n2)
                System.out.printf("%.2f %%%n",(100.00*n2)/n1);
            else
                System.out.printf("%.2f %%%n",(100.00*n1)/n2);
        }
    }
    private static int stringToDigit(String s,  boolean mode)
    {
        int sum=0;
        if(mode)
        {
            char [] c=s.toCharArray();
            for(char x:c)
            {
                if(x>='A'&&x<='Z')
                    sum+=x-64;
                if(x>='a'&&x<='z')
                    sum+=x-96;
            }
        }
        else
        {
            char [] c=s.toCharArray();
            for(char x:c)
            {
                if(x>='1'&&x<='9')
                    sum+=x-48;
            }
        }
        return sum;
    }
}