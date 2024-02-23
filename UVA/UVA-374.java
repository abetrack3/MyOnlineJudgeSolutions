import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    
    public static int x;
    public static int z;
    public static HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while(puttingvaluesinside.hasNext())
        {
            x = puttingvaluesinside.nextInt();
            int y = puttingvaluesinside.nextInt();
            z = puttingvaluesinside.nextInt();
            hm = new HashMap<Integer, Integer>();
            System.out.println(bigMod(y));
        }
    }
    
    public static int bigMod(int y)
    {
        if(y==0)
            return 1%z;
        if(x==0)
            return 0%z;
        if(y==1)
            return x%z;
        int a = 0;
        int left = y/2;
        int right = (y%2==0)? left : left+1;
        if(hm.containsKey(y))
            a = hm.get(y);
        else
        {
            a = (bigMod(left)*bigMod(right))%z;
            hm.put(y, a);
        }

        return a;
    }
    
}