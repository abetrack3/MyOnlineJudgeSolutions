import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader puttingvaluesinside = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(puttingvaluesinside.readLine());
        int arr[] = new int[1000001];
        createSieve(arr);
        while (t!=0)
        {
            boolean flag = true;
            if(arr[t-2]==0)
            {
                System.out.println(t+" = "+2+" + "+(t-2));
                flag = false;
            }
            else
            {
                for(int i = 3; t-i>=i; i += 2)
                {
                    if(arr[t-i] == 0 && arr[i] == 0)
                    {
                        System.out.println(t+" = "+i+" + "+(t-i));
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                System.out.println("Goldbach's conjecture is wrong.");
            t = Integer.parseInt(puttingvaluesinside.readLine());
        }
    }
    
    public static void createSieve(int [] arr)
    {
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=1;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=1;
            }
        }
    }
    
}