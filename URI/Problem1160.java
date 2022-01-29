import java.util.Scanner;
public class Problem1160
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    while(testcases --> 0){
    	double pa = sc.nextInt();
    	double pb = sc.nextInt();
    	double ga = sc.nextDouble() / 100.00;
    	double gb = sc.nextDouble() / 100.00;
    	
    	int ans;
		
		if(gb == 0.0)
			ans = (int)((pa - pb)/(pb*gb - pa*ga)) + 1;
    	else
			ans = (int)(Math.log(pa / pb) / Math.log((1 + gb) / (1 + ga))) + 1;


    	if(ans > 100)
    		System.out.println("Mais de 1 seculo.");
		else
			System.out.println(ans + " anos.");
    	
    }
	sc.close();
  }
}
