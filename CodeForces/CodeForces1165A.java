/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class CodeForces1165A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner puttingvaluesinside=new Scanner(System.in);
		int n=puttingvaluesinside.nextInt(),
			x=puttingvaluesinside.nextInt(),
			y=puttingvaluesinside.nextInt();
		puttingvaluesinside.nextLine();
		char []c=puttingvaluesinside.nextLine().toCharArray();
		int count=0;
		if(c[c.length-1-y]=='0')
			count++;
		for(int i=0;i<c.length&&i<x;i++)
		{
			if(i==y)
				continue;
			if(c[c.length-1-i]=='1')
				count++;
		}
		System.out.println(count);
	}
}
