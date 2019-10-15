import java.util.Scanner;
public class Problem1064
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=0;
    float b=0;
    for(int c=0;c<6;c++)
    {
      float d=puttingvaluesinside.nextFloat();
      if(d>=0)
      {
        b+=d; a++;
      }
    }
    System.out.printf("%d valores positivos\n%.1f\n",a,b/a);
  }
}