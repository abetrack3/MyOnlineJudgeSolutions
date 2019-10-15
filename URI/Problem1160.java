import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Problem1160
{
  public static void main (String[]args) throws IOException
  {
    String[]s;//=new String[4]; //String s1="";
    int p=0;
    float r=0;
    BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
    for(int a=Integer.parseInt(puttingvaluesinside.readLine());a>0;a--)
    {
      s=puttingvaluesinside.readLine().trim().split(" ");
      p=Integer.parseInt(s[1])-Integer.parseInt(s[0]);
      r=Float.parseFloat(s[2])-Float.parseFloat(s[3]);
      System.out.println(Math.round(p/r));
    }
  }
}