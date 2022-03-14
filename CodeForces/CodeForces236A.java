/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.*; 
 
/* Name of the class has to be "Main" only if the class is public. */
public class CodeForces236A
{
	public static void main(String[]args) throws Exception
	{
//		for(int i = 0; true; i++)
//		{
////			String s = getAlphaNumericString((int)(100*Math.random()));
//			String s = getAlphaNumericString(100);
//			System.out.println(s);
//			if(!right(s).equals(wrong(s)))
//			{
//				System.out.println("Debugged: " + s);
//				break;
//			}
//		}
            Scanner puttingvaluesinside = new Scanner(System.in);
            System.out.println(wrong(puttingvaluesinside.nextLine()));
	}
	
	static String getAlphaNumericString(int n) 
    { 
  
        // length is bounded by 256 Character 
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
  
        String randomString 
            = new String(array, Charset.forName("UTF-8")); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(); 
  
        // Append first 20 alphanumeric characters 
        // from the generated random String into the result 
        for (int k = 0; k < randomString.length(); k++) { 
  
            char ch = randomString.charAt(k); 
  
            if (((ch >= 'a' && ch <= 'z') ) 
                && (n > 0)) { 
  
                r.append(ch); 
                n--; 
            } 
        } 
  
        // return the resultant string 
        return r.toString(); 
    }
	
	public static String right(String s)
	{
		char c[] = s.toCharArray();
		HashSet <String> set = new HashSet<String>();
		for(char x:c)
		{
			set.add(""+x);
		}
		if(set.size()%2==0)
			return "CHAT WITH HER!";
		else
			return "IGNORE HIM!";
		
	}
	
	public static String wrong (String s)
	{
		// your code goes here
		// Scanner sc = new Scanner(System.in);
		char c[] = s.toCharArray();
		int count = 0;
		for(int i = 0; i < c.length; i++)
                for(int j = i + 1; j < c.length; j++)
                {
                        if(c[i] == c[j])
                        {
                                count++;
                                break;
                        }
                }
		if((c.length-count)%2 == 0)
			return "CHAT WITH HER!";
		else
			return "IGNORE HIM!";
	}
}
