import java.util.Scanner;
public class Problem1070
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    if(a%2==0)
      a++;
    for(int c=0;c<12;c+=2)
      System.out.println(a+c);
  }
}