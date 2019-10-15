import java.util.Scanner;
public class Problem1197
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    String s[]; int v=0,t=0;
    while(puttingvaluesinside.hasNextLine())
    {
      v=puttingvaluesinside.nextInt();
      t=puttingvaluesinside.nextInt();
      puttingvaluesinside.nextLine(); //For EOF this line of code must be present if the input is not string (not sure about this idea though)
      System.out.println(v*t*2);
    }
  }
}