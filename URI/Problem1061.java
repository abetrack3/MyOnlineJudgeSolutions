import java.util.Scanner;
public class Problem1061
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    puttingvaluesinside.next();
    int a=86400*puttingvaluesinside.nextInt()+3600*puttingvaluesinside.nextInt();
    puttingvaluesinside.next();
    a+=60*puttingvaluesinside.nextInt();
    puttingvaluesinside.next();
    a+=puttingvaluesinside.nextInt();
    puttingvaluesinside.next();
    a-=86400*puttingvaluesinside.nextInt()+3600*puttingvaluesinside.nextInt();
    puttingvaluesinside.next();
    a-=60*puttingvaluesinside.nextInt();
    puttingvaluesinside.next();
    a-=puttingvaluesinside.nextInt();
    a*=-1;
    //System.out.println(a);
    System.out.println(a/86400+" dia(s)\n"+(a%86400)/3600+" hora(s)\n"+(a%3600)/60+" minuto(s)\n"+a%60+" segundo(s)");
  }
}