import java.util.Scanner;
public class Problem1151
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int c=puttingvaluesinside.nextInt();
    if(c==1) System.out.println("0");
    else if(c==2) System.out.println("0 1");
    else if(c==0) {}
    else
    {
      System.out.print("0 1 ");
      int a1=0, a2=1, b=0;
      //Beware of the for loop initiation! c-=2;
      for(c-=2;c>0;c--)
      {
        //System.out.print(b);
        b=a1+a2;
        a1=a2;
        a2=b;
        System.out.print(b);
        if(c!=1) System.out.print(" ");
        else System.out.println();
      }
    }
  }
}