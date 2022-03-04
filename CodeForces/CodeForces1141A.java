import java.util.Scanner;
public class ProblemA
{
    public static void main  (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int from=puttingvaluesinside.nextInt();
        int to=puttingvaluesinside.nextInt();
        
        if(to%from!=0)
        {
            System.out.println(-1);
            return;
        }
        
        if(to==from)
        {
            System.out.println(0);
            return;
        }
        
        int x=to/from;
//        System.out.println(x);
        int moveCount=0;
        while(true)
        {
            if(x==1)
                break;
            if(x%2==0)
            {
                moveCount++;
                x/=2;
            }
            else
                break;
        }
        
//        System.out.println(x);
        while(true)
        {
//            System.out.println(x);
            if(x==1)
                break;
            if(x%3==0)
            {
                moveCount++;
                x/=3;
            }
            else
                break;
        }
        
//        System.out.println(x);
        if(x!=1)
            System.out.println(-1);
        else
            System.out.println(moveCount);
    }
}