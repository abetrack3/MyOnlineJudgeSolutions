import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int size=puttingvaluesinside.nextInt();
        while (size!=0)
        {
            int max=0;
            int curr=0;
            for (int i=0;i<size;i++)
            {
                curr+=puttingvaluesinside.nextInt();
//                System.out.print(curr);
                if (curr<0)
                    curr=0;
                if(curr>max)
                    max=curr;
//                System.out.println(" "+curr+" "+max);
            }
            if (max>0)
                System.out.println("The maximum winning streak is "+max+".");
            else
                System.out.println("Losing streak.");
            size=puttingvaluesinside.nextInt();
        }
    }
}