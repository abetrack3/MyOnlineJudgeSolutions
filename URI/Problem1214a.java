import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Problem1214a
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    for(int a=puttingvaluesinside.nextInt();a>0;a--)
    {
      int sum=0;
      float count=0;
      int array[]=new int[puttingvaluesinside.nextInt()];
      for(int b=0;b<array.length;b++)
      {
        array[b]=puttingvaluesinside.nextInt();
        sum+=array[b];
        array[b]*=array.length;
      }
      for(int x:array)
        if(x>sum) count+=100;
      System.out.println(new BigDecimal(count/array.length).setScale(3,RoundingMode.HALF_EVEN)+"%");
    }
  }
}