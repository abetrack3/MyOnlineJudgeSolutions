//addition method
//wrong output for 25.11
import java.util.Scanner;
public class Problem1021d
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double x=puttingvaluesinside.nextDouble();
    double array[]={100,50,20,10,5,2,1,.5,.25,.1,.05,.01};
    double sum=0;
    System.out.println("NOTAS:");
    for(int count=0;count<array.length;count++)
    {
      if(count==6)
      {
        System.out.println("MOEDAS:");
      }
      int notecount=0;
      while(sum+array[count]<=x)
      {
        sum+=array[count];
        //keyline of this algorithm
        notecount++;
      }
      //System.out.println(sum);
      if(count<6)
      {
        System.out.printf("%d nota(s) de R$ %.2f\n",notecount,array[count]);
      }
      else
      {
        System.out.printf("%d moeda(s) de R$ %.2f\n",notecount,array[count]);
      }
    }
  }
}