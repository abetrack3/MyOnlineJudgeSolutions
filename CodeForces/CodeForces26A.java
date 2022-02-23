import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=puttingvaluesinside.nextInt();
        System.out.println(bruteForceApproach(n));
    }
    
    public static int bruteForceApproach(int n)
    {
        int count=0;
        int arr[]=generateSeve(3001);
        for(int i=1;i<=n;i++)
        {
            int divCount=0;
            for(int j=1;j<=i;j++)
            {
                if(i%j==0&&arr[j]==0)
                    divCount++;
            }
            if(divCount==2)
                count++;
        }
        return count;
    }
    
    public static int usingSeveApproach (int n)
    {
        int arr[]=generateSeve(3001);
        int count=0;
        for(int i=1;i<=n;i++)
        {
            int j=i;
            if(arr[j]==0)
                continue;
            if(j%2==0)
            {
                while(j%2==0)
                    j/=2;
                if(arr[j]==0)
                    count++;
                continue;
            }
            for(int k=3;k*k<=j;k+=2)
            {
                if(arr[k]==0)
                {
                    if(j%k==0)
                    {
                        while(j%k==0)
                            j/=k;
                        if(arr[j]==0)
                            count++;
                    }
                }
            }
        }
        return (count);
    }
    
    public static int[] generateSeve(int size)
    {
        int arr[]=new int[size];
        arr[0]=arr[1]=1;
        for(int i=4;i<=arr.length-1;i+=2)
        {
            arr[i]=1;
        }
        for(int i=3;i*i<=arr.length-1;i+=2)
        {
            if(arr[i]==1)
            {
                continue;
            }
            for(int j=i*i;j<=arr.length-1;j+=i*2)
            {
                arr[j]=1;
            }
        }
        return arr;
    }
}