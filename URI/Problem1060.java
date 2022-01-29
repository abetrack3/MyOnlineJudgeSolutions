import java.util.Scanner;
public class Problem1060
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int b=0;
    for(int c=1;c<=6;c++)
    {
      if(puttingvaluesinside.nextFloat()>=0)
        b++;
    }
    System.out.println(b+" valores positivos");
  }
}