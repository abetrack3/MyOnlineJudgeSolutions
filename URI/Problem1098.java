public class Problem1098
{
  public static void main (String[]args)
  {
    float a=0;
    for(int b=1;a<=2.1;b++)
    {
      //System.out.println(a+" "+(b+a));
      if(a==1 || (a>2 && a<2.1) || a ==0) System.out.printf("I=%.0f J=%.0f\n",a,(b+a));
      else System.out.printf("I=%.1f J=%.1f\n",a,(b+a));
      if(b%3==0)
      {
        b=0;
        a+=0.2f;
      }
    }
  }
}