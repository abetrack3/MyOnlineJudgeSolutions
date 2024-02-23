import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        long runtime = System.nanoTime();
        int arr[] = new int[1001];
        sumOfDivisorSieve(arr);
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        for(int i = 1; t != 0; i++)
        {
            if(map.containsKey(t))
                System.out.println("Case "+i+": "+map.get(t));
            else
                System.out.println("Case "+i+": "+"-1");
            t = puttingvaluesinside.nextInt();
        }
//        System.out.println("map = " + map);
//        testSumOfDivisorSieve(arr);
//        System.out.println(java.util.Arrays.toString(arr));
        runtime = System.nanoTime() - runtime;
//        System.out.println("runtime = " + runtime/1000000);
    }
    
    public static void sumOfDivisorSieve(int arr[])
    {
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = i; j < arr.length; j+=i)
            {
                arr[j] += i;
            }
        }
    }
    
    public static void testSumOfDivisorSieve(int arr[])
    {
        if(arr.length < 2)
        {
            System.out.println("Array size too short");
            return;
        }
        if(arr[0] != 0)
        {
            System.out.println("Error for "+ 0);
            return;
        }
        else if(arr[1] != 1)
        {
            System.out.println("Error for "+1);
            return;
        }
        
        for(int i = 2; i < arr.length; i++)
        {
            long sum = 0;
            for(int j = 1; j <= i; j++)
            {
                if(i%j == 0)
                    sum += j;
            }
            if( arr[i] != sum)
            {
                System.out.println("Error for "+i);
                System.out.println("BruteSum = "+sum);
                System.out.println("QuickSum = "+arr[i]);
            }
        }
    }
    
}