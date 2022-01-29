import java.util.Scanner;
public class Problem1131
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=1,w=0,x=0,y=0,z=0;
    while(a==1)
    {
      w++;
      int b=puttingvaluesinside.nextInt();
      int c=puttingvaluesinside.nextInt();
      if(b>c) x++;
      else if(b<c) y++;
      else z++;
      do
      {
        System.out.println("Novo grenal (1-sim 2-nao)");
        a=puttingvaluesinside.nextInt();
      }while(a>2||a<1);
    }
    System.out.println(w+" grenais");
    System.out.println("Inter:"+x);
    System.out.println("Gremio:"+y);
    System.out.println("Empates:"+z);
    if(x==y) System.out.println("Não houve vencedor");
    else if(x>y) System.out.println("Inter venceu mais");
    else System.out.println("Gremio venceu mais");
  }
}