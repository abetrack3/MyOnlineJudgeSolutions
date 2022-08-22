import java.util.Scanner;
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here\
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++)
			System.out.println("Case " + i + ": " + (sc.nextInt() + sc.nextInt()));
	}
}