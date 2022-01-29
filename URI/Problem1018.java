import java.util.Scanner;
public class Problem1018
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int array[]={100,50,20,10,5,2,1};
    int x=puttingvaluesinside.nextInt();
    System.out.println(x);
    for(int count=0;count<array.length;count++)
    {
      int decomposer=array[count];
      int notecount=0;
      for(int innercount=1;innercount*decomposer<=x;innercount++)
      {
        notecount++;
      }
      x-=notecount*decomposer;
      System.out.println(notecount+" nota(s) de R$ "+array[count]+",00");
    }
    /*
     //Try running this code. You will find a problem that you should be aware of!
     double b=676.65;//try running the code by varying the value of b from 676.61-676.69
     b-=100.0*5.0;
     System.out.println(b);
     */
  }
}