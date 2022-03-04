/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class CodeForces1139A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner puttingvaluesinside=new Scanner(System.in);
		puttingvaluesinside.nextInt();
		puttingvaluesinside.nextLine();
		char []c=puttingvaluesinside.nextLine().toCharArray();
		long sum=0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i]=='2'||c[i]=='4'||c[i]=='6'||c[i]=='8')
				sum+=i+1;
		}
		System.out.println(sum);
	}
}
