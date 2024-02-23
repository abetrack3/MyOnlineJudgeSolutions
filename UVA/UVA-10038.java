import java.util.Scanner;

public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        while(puttingvaluesinside.hasNextInt())
        {
            int n=puttingvaluesinside.nextInt();
            if(n==0)
                continue;
            int arr[]=new int[n-1];
            int a=puttingvaluesinside.nextInt();
            for(int i=0;i<arr.length;i++)
            {
                int b=puttingvaluesinside.nextInt();
                try
                {
                    arr[(int)Math.abs(b-a)-1]++;
                } catch (Exception e){}
                a=b;
            }
            boolean flag=true;
            for(int x:arr)
            {
                if(x==0)
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
        }
    }
}