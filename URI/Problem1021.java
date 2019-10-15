import java.util.Scanner;
public class Problem1021
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int array[]={100000,50000,20000,10000,5000,2000,1000,500,250,100,50,10};
    double x=puttingvaluesinside.nextDouble();
    //Try giving an input of 576.43 to unleash hell upon yourself :)
    x*=1000;
    int y=(int)x;
    //System.out.println(y);
    System.out.println("NOTAS:");
    for(int count=0;count<array.length;count++)
    {
      if(count==6)
      {
        System.out.println("MOEDAS:");
      }
      int decomposer=array[count];
      int notecount=0;
      for(int innercount=1;innercount*decomposer<=y;innercount++)
      {
        notecount++;
      }
      y-=notecount*decomposer;
      if(count<6)
      {
        System.out.println(notecount+" nota(s) de R$ "+array[count]/1000+".00");
      }
      else
      {
        //System.out.println(notecount);
        System.out.printf("%d moedas(s) de R$ %.2f\n",notecount,(double)array[count]/1000);
      }
    }
    /*
     //Try running this code. You will find a problem that you should be aware of!
     double b=676.65;//try running the code by varying the value of b from 676.61-676.69
     b-=100.0*5.0;
     System.out.println(b);
     */
  }
}