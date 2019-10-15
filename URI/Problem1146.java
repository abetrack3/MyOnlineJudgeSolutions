import java.util.Scanner;
public class Problem1146
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    String s="";
    while(a!=0)
    {
      s="";
      for(int c=1;c<=a;c++)
      {
        s+=""+c;//System.out.print(c);
        if(c%a==0) s+="\n";//System.out.println();
        else s+=" ";//System.out.print(" ");
      }
      //System.out.println();
      System.out.print(s);
      a=puttingvaluesinside.nextInt();
    }
    //System.out.print(s);
  }
}