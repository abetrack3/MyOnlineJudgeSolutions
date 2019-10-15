import java.util.Scanner;
public class Problem1159
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    while(a!=0)
    {
      //The program starts to give weird/wrong outputs
      //If you set the if statement to if(a%2==1)
      //Under this circumstances try the following commented code.
      //Or just try it in the interaction pane.
      //Try this//System.out.println((-93)%2==1);
      if(a%2!=0) a++;
      System.out.println((a+4)*5);
      a=puttingvaluesinside.nextInt();
    }
  }
}
//System.out.println((-93)%2==1); would give false because the modulus output is -1 not +1
//So if you set the if statement to if((a%2==1)||(a%2==-1)) then the program should work fine for both positive and negative output.