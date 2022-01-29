import java.util.Scanner;
public class Problem1182
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float array[][]=new float[12][12];
    int line=puttingvaluesinside.nextInt();
    puttingvaluesinside.nextLine();
    boolean flag;
    if(puttingvaluesinside.nextLine().equals("S")) flag=false;
    else flag=true;
    for(int a=0;a<12;a++)
    {
      for(int b=0;b<12;b++)
      {
        array[a][b]=puttingvaluesinside.nextFloat();
      }
    }
    if(flag)
    {
      float sum=0;
      for(int a=0;a<12;a++) sum+=array[a][line];
      System.out.printf("%.1f\n",sum/12.0);
    }
    else
    {
      float sum=0;
      for(int a=0;a<12;a++) sum+=array[a][line];
      System.out.println(sum);
    }
  }
}