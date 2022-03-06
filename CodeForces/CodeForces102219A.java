import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeForces102219A
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String z[] = sc.readLine().split(" ");
        int i = Integer.parseInt(z[0]);
        char []s=z[1].toCharArray();
        int rcount=0, lcount=0;
        for(char x:s)
        {
            if(x=='R')
                rcount++;
            else if(x=='L')
                lcount++;
        }
        rcount%=4;
        lcount%=4;
        char [][]arr=new char[i][i];
        for(int j=0;j<i;j++)
            arr[j]=sc.readLine().toCharArray();
        if(rcount>lcount)
        {
            rcount-=lcount;
            switch (rcount)
            {
                case 0: printOriginal(arr); break;
                case 1: printRight(arr); break;
                case 2: printOpposite(arr); break;
                case 3: printLeft(arr); break;
            }
        }
        else
        {
            lcount-=rcount;
            switch (lcount)
            {
                case 0: printOriginal(arr); break;
                case 1: printLeft(arr); break;
                case 2: printOpposite(arr); break; 
                case 3: printRight(arr); break;
            }
        }
    }
    
    public static void printOriginal(char c[][]) throws Exception
    { 
        StringBuilder out = new StringBuilder();
        for(char []x:c)
        {
            for(char y:x)
                out.append(y);
            out.append('\n');
        }
        System.out.print(out);
    }
    
    public static void printLeft(char c[][]) throws Exception
    {
        StringBuilder out = new StringBuilder();
        for(int i=c.length-1;i>=0;i--)
        {
            for(int j=0;j<c.length;j++)
            {
                char x=c[j][i];
                if(x=='>')
                    x='^';
                else if(x=='v')
                    x='>';
                else if(x=='<')
                    x='v';
                else if(x=='^')
                    x='<';
                out.append(x);
            }
            out.append('\n');
        }
        System.out.print(out);
    }
    
    public static void printRight(char c[][]) throws Exception
    {
        StringBuilder out = new StringBuilder();
        for(int i=0;i<c.length;i++)
        {
            for(int j=c.length-1;j>=0;j--)
            {
                char x=c[j][i];
                if(x=='>')
                    x='v';
                else if(x=='v')
                    x='<';
                else if(x=='<')
                    x='^';
                else if(x=='^')
                    x='>';
                out.append(x);
            }
            out.append('\n');
        }
        System.out.print(out);
    }
    
    public static void printOpposite(char c[][]) throws Exception
    {
        StringBuilder out = new StringBuilder();
        for(int i=c.length-1;i>=0;i--)
        {
            for(int j=c.length-1;j>=0;j--)
            {
                char x=c[i][j];
                if(x=='>')
                    x='<';
                else if(x=='v')
                    x='^';
                else if(x=='<')
                    x='>';
                else if(x=='^')
                    x='v';
                out.append(x);
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}