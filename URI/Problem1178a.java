import java.util.Scanner;
public class Problem1178a
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    double n[] = new double[100];
    double x = input.nextDouble();
    n[0] = x;
    String formatX = String.format("%.4f", n[0]);            
    System.out.println("N[" + (0) + "] = " + formatX);        
    for (int i = 1; i < n.length; i++)
    {
      n[i] = n[i-1] / 2;            
      String format = String.format("%.4f", n[i]);            
      System.out.println("N[" + (i) + "] = " + format);
    }        
  }
}