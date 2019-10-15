import java.util.Scanner;
public class Problem1214
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    for(int test=puttingvaluesinside.nextInt();test>0;test--)
    {
      int array[]=new int[puttingvaluesinside.nextInt()];
      int sum=0;
      for(int testest=array.length;testest>0;testest--)
      {
        array[testest-1]=puttingvaluesinside.nextInt();
        sum+=array[testest-1];
      }
      float average=(float)sum/array.length;
      int count=0;
      for(float x:array)
      {
        if(x>average) count++;
      }
      System.out.printf("%.3f%%%n",(float)count/array.length*100.00);
    }
  }
}