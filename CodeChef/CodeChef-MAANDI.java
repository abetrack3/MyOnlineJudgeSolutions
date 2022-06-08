import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int a=puttingvaluesinside.nextInt();
            int count=0;
            for(int i=1;i*i<=a;i++)
            {
                if(a%i==0)
                {
                    if((""+i).indexOf('4')>=0||(""+i).indexOf('7')>=0)
                        count++;
                    if(((""+(a/i)).indexOf('4')>=0||(""+(a/i)).indexOf('7')>=0)&&(a/i!=i))
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}