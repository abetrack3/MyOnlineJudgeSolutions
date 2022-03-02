//Largest Sum Contiguous Subarray
//Kandane's Algorithm

import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=puttingvaluesinside.nextInt();
        int count=0, max=0, sum=0;
        for(int j=0;j<n;j++)
        {
            int a=puttingvaluesinside.nextInt();
            if(a==0)
                sum++;
            else
            {
                sum--;
                count++;
            }
            if(sum<0)
                sum=0;
            if(sum>max)
                max=sum;
        }
        if(count==n)
            System.out.println(count-1);
        else
            System.out.println(max+count);
    }
}