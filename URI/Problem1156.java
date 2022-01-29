public class Problem1156
{
  public static void main (String[]args)
  {
    float a=0;
    for(float b=1, c=1;b<=39;b+=2,c*=2)
      a+=b/c;
    System.out.printf("%.2f\n",a);
  }
}