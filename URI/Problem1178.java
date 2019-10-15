import java.util.Scanner;
public class Problem1178
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float a[]=new float[20]; int b=0; String s="";
    a[0]=puttingvaluesinside.nextFloat();
    for(int c=1;c<a.length;c++){a[c]=a[c-1]/2;} //s=String.format("%.4f",a[c]);}
    {
//      a[c]=(a[c-1]*10000);
//      System.out.println(a[c]);
//      b=(int)a[c]/1;
//      a[c]=b/(float)20000;
    }
    //for(int c=0;c<a.length;c++) System.out.printf("N[%d] = %.4f\n",c,a[c]);
    for(int c=0;c<a.length;c++) {s=String.format("%.4f",a[c]); System.out.printf("N[%d] = %s\n",c,s);}
//    float a=(float)0.78125;
//    int b=(int)(a*10000);
//    a=(float)b/10000;
//    System.out.println(a);
  }
}