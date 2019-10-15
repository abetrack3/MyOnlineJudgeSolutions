import java.util.Scanner;
public class Problem1041
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float x=puttingvaluesinside.nextFloat(), y=puttingvaluesinside.nextFloat();
    if((x==0)&&(y==0))
    {
      System.out.println("Origem");
    }
    else if((x==0))
    {
      System.out.println("Eixo Y");
    }
    else if(y==0)
    {
      System.out.println("Eixo X");
    }
    else if((x>0)&&(y>0))
    {
      System.out.println("Q1");
    }
    else if((x>0)&&(y<0))
    {
      System.out.println("Q4");
    }
    else if((x<0)&&(y>0))
    {
      System.out.println("Q2");
    }
    else
    {
      System.out.println("Q3");
    }
  }
}