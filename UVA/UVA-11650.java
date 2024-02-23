import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        for(;t>0;t--)
        {
            String [] s=puttingvaluesinside.nextLine().split(":",2);
            int h=Integer.parseInt(s[0]);
            if(h==12) h=0;
            int m=Integer.parseInt(s[1]);
            int n=720-h*60-m;
            if(n/60<10)
            {
                if(n/60==0)
                    System.out.print("12");
                else
                    System.out.print("0"+n/60);
            }
            else
                System.out.print(n/60);
            if(n%60<10)
                System.out.println(":0"+n%60);
            else
                System.out.println(":"+n%60);
        }
    }
}