import java.util.Scanner;
public class Problem1435
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int n=puttingvaluesinside.nextInt();
    while(n!=0)
    {
      int array[]=new int[n];
      int  m=n/2;
      for(int a=0;a<m;a++)
      {
        for(int b=0;b<array.length;b++) if(b>=a&&((a+b)<array.length)) array[b]++;
        arrayPrint(array);
      }
      if(n%2!=0) {array[m]++; arrayPrint(array);}
      for(int a=m;a>0;a--)
      {
        for(int b=0;b<array.length;b++) if(b>=a&&((a+b)<array.length)) array[b]--;
        arrayPrint(array);
      }
      System.out.println();
      n=puttingvaluesinside.nextInt();
    }
  }
  public static void arrayPrint(int array[])
  {
    for(int x=0;x<array.length;x++)
    {
      if(array[x]>99) System.out.print(array[x]);
      else if(array[x]>9) System.out.print(" "+array[x]);
      else System.out.print("  "+array[x]);
      if(x==array.length-1) System.out.println();
      else System.out.print(" ");
    }
  }
}