/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class CodeForces1165B
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner puttingvaluesinside=new Scanner(System.in);
		int arr[]=new int[200000];
		for(int i=puttingvaluesinside.nextInt();i>0;i--)
			arr[puttingvaluesinside.nextInt()-1]++;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				while(true)
				{
					if(i>=count&&arr[i]>0)
					{
						arr[i]--;
						count++;
					}
					else break;
				}
			}
		}
		System.out.println(count);
	}
}
