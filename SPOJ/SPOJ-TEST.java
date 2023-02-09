import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 42)
        {
            System.out.println(t);
            t = sc.nextInt();
        }
    }
}