import java.util.Scanner;
public class Problem1176
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    //Declaring the array in long data types.
    long b[];
    for(int a=puttingvaluesinside.nextInt();a>0;a--)
    {
      //In the next line declaring the array size is one of the key code.
      b=new long[puttingvaluesinside.nextInt()+1];
      if(b.length>=2) b[1]=1;
      for(int c=2;c<b.length;c++) b[c]=b[c-1]+b[c-2];
      System.out.println("Fib("+(b.length-1)+") = "+b[b.length-1]);
    }
  }
}