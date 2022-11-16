//Source of the formula that is being used:
//https://math.stackexchange.com/questions/49787/area-between-three-circles-of-differing-radii

import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=puttingvaluesinside.nextInt();
        for(int i=1;i<=n;i++)
        {
            double r1=puttingvaluesinside.nextDouble(),
                r2=puttingvaluesinside.nextDouble(),
                r3=puttingvaluesinside.nextDouble();
            double result=Math.sqrt(r1*r2*r3*(r1+r2+r3))
                -(r1*r1*Math.acos(1-2*r2*r3/((r1+r2)*(r1+r3)))
                      +r2*r2*Math.acos(1-2*r1*r3/((r1+r2)*(r2+r3)))
                      +r3*r3*Math.acos(1-2*r2*r1/((r3+r2)*(r1+r3))))/2.0;
                System.out.println("Case "+i+": "+result);
        }
    }
}