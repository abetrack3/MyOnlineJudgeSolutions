import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        char []c=puttingvaluesinside.nextLine().toCharArray();
        for(char x:c)
        {
            switch (x)
            {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                case 'y':
                case 'Y': {continue;}
            }
            System.out.print('.'+(""+x).toLowerCase());
        }
        System.out.println();
    }
}