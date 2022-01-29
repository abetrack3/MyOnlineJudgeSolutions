import java.util.Scanner;
public class Problem1040
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    //float a=puttingvaluesinside.nextFloat(), b=puttingvaluesinside.nextFloat(), c=puttingvaluesinside.nextFloat(), d=puttingvaluesinside.nextFloat();
    float average=2*puttingvaluesinside.nextFloat();
    average+=3*puttingvaluesinside.nextFloat();
    average+=4*puttingvaluesinside.nextFloat();
    average+=puttingvaluesinside.nextFloat();
    average/=10;
    System.out.printf("Media: %.1f\n",average);
    if(average>=7.0)
    {
      System.out.println("Aluno aprovado.");
    }
    else if(average<5.0)
    {
      System.out.println("Aluno reprovado.");
    }
    else if((average<=6.9)&&(average>=5.0))
    {
      float extra=puttingvaluesinside.nextFloat();
      average+=extra;
      System.out.println("Aluno em exame.");
      System.out.println("Nota do exame: "+extra);
      average/=2;
      if(average>=5.0)
      {
        System.out.println("Aluno aprovado.");
      }
      else if(average<=4.9)
      {
        System.out.println("Aluno reprovado.");
      }
      System.out.printf("Media final: %.1f\n",average);
    }
  }
}