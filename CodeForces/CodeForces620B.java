import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int j=puttingvaluesinside.nextInt();
        int i=puttingvaluesinside.nextInt();
        long sum=0;
        while(j<=i)
        {
            char [] c=(""+j).toCharArray();
            for(int k=0;k<c.length;k++)
            {
                switch (c[k])
                {
                    case '0': {sum+=6;break;}
                    case '1': {sum+=2;break;}
                    case '2': {sum+=5;break;}
                    case '3': {sum+=5;break;}
                    case '4': {sum+=4;break;}
                    case '5': {sum+=5;break;}
                    case '6': {sum+=6;break;}
                    case '7': {sum+=3;break;}
                    case '8': {sum+=7;break;}
                    case '9': {sum+=6;break;}
                }
            }
            j++;
        }
        System.out.println(sum);
    }
}