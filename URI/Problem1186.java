import java.util.Scanner;
public class Problem1186
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    boolean flag=false;
    if(puttingvaluesinside.nextLine().equals("M")) flag=true;
    float sum=0;
    for(int a=0;a<12;a++)
      for(int b=0;b<12;b++)
    {
      if(11<a+b)
      sum+=puttingvaluesinside.nextFloat();
      else puttingvaluesinside.nextFloat(); //If you don't put else here the program doesn't take all the 144 number inputs.
    }
    if(flag) System.out.printf("%.1f\n",sum/66.0);
    else System.out.println(sum);
  }
}