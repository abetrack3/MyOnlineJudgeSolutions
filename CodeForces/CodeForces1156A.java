import java.util.Scanner;
public class CodeForces1156A
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int total=0;
        int n=puttingvaluesinside.nextInt()-1;
        int a=puttingvaluesinside.nextInt(), z=0;
        boolean flag=true;
        while(n-->0)
        {
            int b=puttingvaluesinside.nextInt();
            if(a+b==5)
                flag=false;
            else if(a+b==3)
            {
                if(z==3)
                    total+=2;
                else
                    total+=3;
            }
            else if(a+b==4)
                total+=4;
//            System.out.println(a+" "+b+" "+total);
            z=a;
            a=b;
        }
        if(flag)
            System.out.println("Finite\n"+total);
        else
            System.out.println("Infinite");
    }
}
