import java.util.Scanner;
public class Problem1066
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int ec=0, oc=0, pc=0, nc=0;
    for(int c=0,d=0;c<5;c++)
    {
      d=puttingvaluesinside.nextInt();
      if(d%2==0)
        ec++;
      else
        oc++;
      if (d<0)
        nc++;
      else if(d>0)
        pc++;
    }
    System.out.println(ec+" valor(es) par(es)\n"+oc+" valor(es) impar(es)\n"+pc+" valor(es) positivo(s)\n"+nc+" valor(es) negativo(s)");
  }
}