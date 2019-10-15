import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Problem1146c
{
  public static void main (String[]args) throws IOException
  {
    StringBuilder s=new StringBuilder();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int a=1, b=Integer.parseInt(br.readLine());
    while(b!=0)
    {
      s.append(a);
      if(a==b)
      {
        s.append("\n");
        a=1;
        b=Integer.parseInt(br.readLine());
        System.out.print(s);
        s=new StringBuilder();
      }
      else
      {
        s.append(" ");
        a++;
      }
    }
  }
}