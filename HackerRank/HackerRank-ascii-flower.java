import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int r=puttingvaluesinside.nextInt();
        int c=puttingvaluesinside.nextInt();
        for(int b=0;b<r;b++)
        {
            for(int a=0;a<c;a++)
                System.out.print("..O..");
            System.out.println();
            for(int a=0;a<c;a++)
                System.out.print("O.o.O");
            System.out.println();
            for(int a=0;a<c;a++)
                System.out.print("..O..");
            System.out.println();
        }
    }
}