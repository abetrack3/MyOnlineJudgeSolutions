import java.util.Scanner;
public class Problem1146a
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=1, b=puttingvaluesinside.nextInt();
    String s="";
    while(b!=0)
    {
      s+=a;
      //System.out.print(a);
      if(a==b)
      {
        //System.out.print(a);
        s+="\n";
        //System.out.println();
        a=1;
        //System.out.print(s);

        b=puttingvaluesinside.nextInt();
      }
      else
      {
        s+=" ";
        //System.out.print(" ");
        a++;
      }
    }
  }
}