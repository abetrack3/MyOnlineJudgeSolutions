public class Problem1155
{
  public static void main (String[]args)
  {
    float a=0;
    for(float c=1;c<=100;c++)
      a+=1/c;
    System.out.printf("%.2f\n",a);
  }
}