/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner puttingvaluesinside = new Scanner(System.in);
		int t = puttingvaluesinside.nextInt();
		while(t-->0)
		{
			long k = puttingvaluesinside.nextLong();
			System.out.println(sumOfDivisor(k));
		}
	}
 
	public static long sumOfDivisor(long t)
    {
        if(t == 0 || t == 1) return t;
        long sum = 1;
        //divides by two
        if(t % 2 == 0)
        {
            long count = 1;
            while (t % 2 == 0)
            {
                count *= 2;
                t /= 2;
            }
            count *= 2;
            count--;
            sum *= count;
        }
        for (int i = 3; i*i <= t; i+=2)
        {
            if (t % i == 0)
            {
                long count = 1;
                while (t % i == 0)
                {
                    count *= i;
                    t /= i;
                }
                count *= i;
                count--;
                count /= i-1;
                sum *= count;
            }
        }
        if (t > 2)
        {
            long count = t * t - 1;
            count /= t - 1;
            sum *= count;
        }
        return sum;
    }
 
}