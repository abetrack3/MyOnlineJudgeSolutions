import java.util.Scanner;
public class Problem1564
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int n=0;
    while(puttingvaluesinside.hasNextLine())
    {
      n=puttingvaluesinside.nextInt();
      puttingvaluesinside.nextLine();
      if(n==0) System.out.println("vai ter copa!");
      else System.out.println("vai ter duas!");
    }
  }
}