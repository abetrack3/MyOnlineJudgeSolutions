import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        puttingvaluesinside.nextInt();
        int i=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        int max=0, wins=0;
        for(;i>0;i--)
        {
            char [] c=puttingvaluesinside.nextLine().toCharArray();
            boolean flag=false;
//            int wins=0;
            for(char x:c)
            {
                if(x=='0')
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
                wins++;
            else
            {
                if(wins>max)
                    max=wins;
                wins=0;
            }
//            System.out.println(wins);
        }
        if(wins>max)
            max=wins;
        System.out.println(max);
    }
}