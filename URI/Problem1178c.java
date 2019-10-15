//This code got accepted but unfortunately this is not my code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Problem1178c
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        String[] str = in.readLine().split(" ");
        double[] a = new double[100];
        for (int i = 0; i < 100; i++)
        {
            if(i == 0)
                a[i] = Double.parseDouble(str[0]);
            else
                a[i] = a[i-1]/(double)2;
        } 
        for (int i = 0; i < 100; i++)
        {
           System.out.println("N["+i+"] = "+new BigDecimal(a[i]).setScale(4,RoundingMode.HALF_EVEN));
        } 
    }
}