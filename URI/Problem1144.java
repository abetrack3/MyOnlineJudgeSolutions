import java.util.Scanner;
public class Problem1144
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    for(int b=puttingvaluesinside.nextInt(),a=b;b>0;b--)
    {
      System.out.println((a-b+1)+" "+(a-b+1)*(a-b+1)+" "+(a-b+1)*(a-b+1)*(a-b+1)+"\n"+(a-b+1)+" "+((a-b+1)*(a-b+1)+1)+" "+((a-b+1)*(a-b+1)*(a-b+1)+1));
    }
  }
}