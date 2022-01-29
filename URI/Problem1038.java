import java.util.Scanner;
public class Problem1038
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    switch (puttingvaluesinside.nextInt())
    {
      case 1: System.out.printf("Total: R$ %.2f\n",(puttingvaluesinside.nextInt())*4.0); break;
      case 2: System.out.printf("Total: R$ %.2f\n",(puttingvaluesinside.nextInt())*4.5); break;
      case 3: System.out.printf("Total: R$ %.2f\n",(puttingvaluesinside.nextInt())*5.0); break;
      case 4: System.out.printf("Total: R$ %.2f\n",(puttingvaluesinside.nextInt())*2.0); break;
      case 5: System.out.printf("Total: R$ %.2f\n",(puttingvaluesinside.nextInt())*1.5); break;
    }
  }
}