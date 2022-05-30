import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        run();
//        test();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while (t-->0)
        {
            int k = puttingvaluesinside.nextInt();
//            System.out.println(k+" "+bruteForce(k));
//            System.out.println(k+" "+hope(k));
//            System.out.println(k+" "+CountPairs(k));
//            System.out.println(k+" "+hope2(k));
            System.out.println(hope2(k));
        }
    }
    
    public static Fraction hope2(long n)
    {
        if(n == 1) return new Fraction(1, 1);
        long sum = 0;
        for(long i = 1; i*i <= n; i++)
        {
            long start = n / i;
            long end = 1 + ( n / ( i + 1) );
            sum += i * ( (long)Math.abs( start - end ) + 1 );
            sum += start;
            if(start == i) sum -= start;
        }
        return new Fraction(sum, n);
    }
    
    public static Fraction bruteForce(int n)
    {
        int count = 0;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(gcd(i, j) == j)
                    count++;
            }
        }
        return new Fraction(count, n);
    }
    
    public static Fraction hope(int n)
    {
        final double eulerMascheroniConstant = Double.parseDouble("0.57721566490153286");
        long numerator = (long)Math.floor(n*(eulerMascheroniConstant + Math.log(n)));
        return new Fraction(numerator, n*n);
    }
    
    //https://www.geeksforgeeks.org/count-number-pairs-n-b-n-gcd-b-b/
    public static Fraction CountPairs(int n) { 
          
        // initialize k 
        int k = n; 
      
        // loop till imin <= n 
        int imin = 1; 
      
        // Initialize result 
        int ans = 0; 
      
        while (imin <= n) { 
      
            // max i with given k floor(n/k) 
            int imax = n / k; 
          
            // adding k*(number of i with 
            // floor(n/i) = k to ans 
            ans += k * (imax - imin + 1); 
          
            // set imin = imax + 1  
            // and k = n/imin 
            imin = imax + 1; 
            k = n / imin; 
        } 
      
        return new Fraction(ans, n); 
    } 
    
    public static int gcd(int a, int b)
    {
        if(a == 0 || b == 0) return a + b;
        return gcd(b%a, a);
    }
    
    public static void test()
    {
        for (int i = 1; i < 100000; i++)
        {
            Fraction f1 = bruteForce(i);
            //check for overflow
            if(f1.numerator < 0 || f1.denominator < 0)
            {
                System.out.println("OverFlow detected at f1 for "+i);
                System.out.println("f1.numerator = " + f1.numerator);
                System.out.println("f1.denominator = " + f1.denominator);
                return;
            }
            Fraction f2 = hope2(i);//CountPairs(i);
            if(f2.numerator < 0 || f2.denominator < 0)
            {
                System.out.println("OverFlow detected at f2 for "+i);
                System.out.println("f2.numerator = " + f2.numerator);
                System.out.println("f2.denominator = " + f2.denominator);
                return;
            }
            if (!(f1.numerator == f2.numerator && f1.denominator == f2.denominator))
            {
                System.out.println("Error for "+i);
                System.out.println("f1 = " + f1);
                System.out.println("f2 = " + f2);
                return;
            }
            System.out.println("i = " + i);
        }
        
    }
    
}

class Fraction
{
    long numerator;
    long denominator;
    Fraction (long n, long d)
    {
        numerator = n;
        denominator = d;
        denominator *= (long)d;
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    public static long gcd(long a, long b)
    {
        if(a == 0 || b == 0) return a + b;
        return gcd(b%a, a);
    }
    public String toString()
    {
        return numerator+"/"+denominator;
    }
}