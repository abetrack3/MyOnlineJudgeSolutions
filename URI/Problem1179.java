import java.util.Scanner;
public class Problem1179
{
  static int even[]=new int[5];
  static int odd[]=new int[5];
  static int evenRecord=0;
  static int oddRecord=0;
  static int input;
  static Scanner puttingvaluesinside=new Scanner (System.in);
  public static void main (String[]args)
  {
    for(int a=1;a<=15;a++)
    {
      takeInput();
    }
      printOddStack(oddRecord);
      printEvenStack(evenRecord);
  }
  public static void takeInput()
  {
    input=puttingvaluesinside.nextInt();
    if(input%2==0) stackTheEven(input);
    else stackTheOdd(input);
  }
  public static void stackTheEven(int a)
  {
    even[evenRecord]=a;
    if(evenRecord!=4)
    {
      evenRecord++;
    }
    else
    {
      printEvenStack(evenRecord+1);
      even=new int[5];
      evenRecord=0;
    }
  }
  public static void stackTheOdd(int a)
  {
    odd[oddRecord]=a;
    if(oddRecord!=4)
    {
      oddRecord++;
    }
    else
    {
      printOddStack(oddRecord+1);
      odd=new int[5];
      oddRecord=0;
    }
  }
  public static void printEvenStack(int b)
  {
    for(int a=0;a<b;a++)
    {
      System.out.println("par["+a+"] = "+even[a]);
    }
  }
  public static void printOddStack(int b)
  {
    for(int a=0;a<b;a++)
    {
      System.out.println("impar["+a+"] = "+odd[a]);
    }
  }
}