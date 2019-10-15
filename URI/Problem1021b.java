import java.util.Scanner;
public class Problem1021b
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float x=puttingvaluesinside.nextFloat();
    System.out.println("NOTAS:");
    int numcount=0;
    for(int count=1;count<=x*100;count++)
    {
      numcount++;
    }
    int array[]={10000,5000,2000,1000,500,200,100,50,25,10,5,1};
    int notecount=0;
    for(int count=0;count<array.length;count++)
    {
      if(count==6)
      {
        System.out.println("MOEDAS:");
      }
      int decomposer=array[count];
      for(int innercount=1;innercount*decomposer<=numcount;innercount++)
      {
      notecount++;
      }
      numcount-=notecount*decomposer;
      if(count<6)
      {
        System.out.println(notecount+" nota(s) de R$ "+array[count]/100+".00");
      }
      else
      {
        System.out.printf("%d moedas(s) de R$ %.2f\n",notecount,(double)array[count]/100);
      }
      notecount=0;
    }
  }
}