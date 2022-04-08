import java.util.Scanner;
import java.util.regex.Pattern;
public class Main
{
    public static void main(String[] args)
    {
        bruteForce();
    }

    public static void bruteForce()
    {
        char arr[] = (new java.util.Scanner(System.in)).nextLine().toCharArray();
        if(search("AB", "BA", arr) || search("BA", "AB", arr))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static boolean search(String s1, String s2, char arr[])
    {
        if(arr.length < 4) return false;
        boolean flag = false;
        int i;
        for(i = 1; i < arr.length; i++)
            if(("" + arr[i - 1] + arr[i]).equals(s1))
            {
                flag = true;
                break;
            }
        if(flag)
        {
            flag = false;
            for(i= i + 2; i < arr.length; i++)
                if(("" + arr[i - 1] + arr[i]).equals(s2))
                    return true;
            return false;
        }
        else return false;
    }


    public static void approachUsingRegex()
    {
        //TLE na khaile this would have been so satisfying :'')
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern pattern1 = Pattern.compile("[A-Z]*AB[A-Z]*BA[A-Z]*");
        Pattern pattern2 = Pattern.compile("[A-Z]*BA[A-Z]*AB[A-Z]*");
        if(pattern1.matcher(s).find() || pattern2.matcher(s).find())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
