import java.util.Scanner;
public class Problem1180
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int count=puttingvaluesinside.nextInt();
    int min=puttingvaluesinside.nextInt();
    int minPosition=0;
    for(int a=1,b=0;count>1;count--,a++)
    {
      b=puttingvaluesinside.nextInt();
      if(b<min)
      {
        min=b;
        minPosition=a;
      }
    }
    System.out.println("Menor valor: "+min+"\nPosicao: "+minPosition);
  }
}