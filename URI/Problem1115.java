import java.util.Scanner;
public class Problem1115
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int x=puttingvaluesinside.nextInt();
    int y=puttingvaluesinside.nextInt();
    while(x!=0&&y!=0)
    {
      if(x>0)
      {
        if(y>0) System.out.println("primeiro");
        else System.out.println("quarto");
      }
      else if(y>0) System.out.println("segundo");
      else System.out.println("terceiro");
      x=puttingvaluesinside.nextInt();
      y=puttingvaluesinside.nextInt();
    }
  }
}