import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Problem1154
{
  public static void main (String[]args) throws IOException
  {
    BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
    int a=0, b=Integer.parseInt(puttingvaluesinside.readLine()), c=0;
    //if(b<0) c--;
    while(b>0)
    {
      c++;
      a+=b;
      b=Integer.parseInt(puttingvaluesinside.readLine());
    }
    System.out.printf("%.2f\n",(float)a/c);
  }
}