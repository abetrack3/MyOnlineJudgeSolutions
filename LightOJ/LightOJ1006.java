import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        for(int i = 1; i <= t; i++)
        {
            ArrayList<Long>arr = new ArrayList<Long>();
            arr.add(puttingvaluesinside.nextLong());
            arr.add(puttingvaluesinside.nextLong());
            arr.add(puttingvaluesinside.nextLong());
            arr.add(puttingvaluesinside.nextLong());
            arr.add(puttingvaluesinside.nextLong());
            arr.add(puttingvaluesinside.nextLong());
            int n = puttingvaluesinside.nextInt();
            System.out.println("Case "+i+": "+solve(n, arr));
        }
    }
    
    public static long solve(int n, ArrayList<Long> arr)
    {
        if(n < 6) return arr.get(n) % 10000007;
        for(int i = 6; i <= n; i++)
        {
            long temp = addMod(arr.get(i-6), arr.get(i - 5), 10000007);
            for(int j = i - 4; j < i; j++)
                temp = addMod(temp, arr.get(j), 10000007);
            arr.add(temp);
        }
        
        return arr.get(arr.size()-1);
    }
    
    public static long addMod(long a, long b, long c)
    {
        return ((a%c)+(b%c))%c;
    }
    
}
