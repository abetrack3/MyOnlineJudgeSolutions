import java.util.Scanner;
public class Problem1478
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int size=puttingvaluesinside.nextInt();
    while(size!=0)
    {
      for(int a=1;a<=size;a++)
      {
        for(int b=1,c=a,d=-1;b<=size;b++,c+=d)
        {
          if(c>99) System.out.print(c);
          else if(c>9) System.out.print(" "+c);
          else System.out.print("  "+c);
          if(c==1) d=1;
          if(b==size) System.out.println();
          else System.out.print(" ");
        }
      }
      size=puttingvaluesinside.nextInt();
      System.out.println();
    }
  }
}