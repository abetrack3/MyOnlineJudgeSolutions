import java.util.Scanner;
public class Problem1789
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    String s[];
    int max;
    while(puttingvaluesinside.hasNextInt())
    {
      puttingvaluesinside.nextInt();
      puttingvaluesinside.nextLine();
      s=puttingvaluesinside.nextLine().trim().split(" ");
      max=Integer.parseInt(s[0]);
      for(String t:s)
      {
        max=Math.max(max,Integer.parseInt(t));
        if(max>=20) break;
      }
      if(max>=20) System.out.println(3);
      else if(max>=10) System.out.println(2);
      else System.out.println(1);
    }
  }
}