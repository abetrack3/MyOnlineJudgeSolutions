//Volume of frustum cone
//Volume= (1/3)(pi)(h)(r1*r1+r2*r2+r1*r2)

import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=puttingvaluesinside.nextInt();
        for(int i=1;i<=n;i++)
        {
            double r1=puttingvaluesinside.nextInt(),
                r2=puttingvaluesinside.nextInt(),
                h=puttingvaluesinside.nextInt(),
                p=puttingvaluesinside.nextInt();
            double result=Math.PI/3.0*p*(r2*r2+(r2+p*(r1-r2)/h)*(r2+p*(r1-r2)/h)+r2*(r2+p*(r1-r2)/h));
            char c[]=(""+result).toCharArray();
            System.out.print("Case "+i+": "+result);
//            for(int j=0;j<12&&j<c.length;j++)
//                System.out.print(c[j]);
            System.out.println();
        }
    }
}