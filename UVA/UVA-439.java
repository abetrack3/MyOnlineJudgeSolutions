/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int matrix[][]=createKnightMatrix();
        while(puttingvaluesinside.hasNextLine())
        {
            StringTokenizer st=new StringTokenizer(puttingvaluesinside.nextLine());
            String start=((String)st.nextElement());
            String end=((String)st.nextElement());
            int steps=shortestRoute(matrix, getNode(start), getNode(end));
            System.out.printf("To get from %s to %s takes %d knight moves.\n", start, end, steps);
        }
    }
    
    public static int[][] createKnightMatrix()
    {
        int matrix[][]=new int[65][65];
        int board[][]=new int[9][9];
        for(int i=1;i<board.length;i++)
        {
            for(int j=1;j<board.length;j++)
            {
                int m=(i-1)*8+j;
                int n;
                int x1;
                int y1;
                x1=i-1;
                y1=j+2;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i+1;
                y1=j+2;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i+2;
                y1=j+1;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i+2;
                y1=j-1;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i-1;
                y1=j+2;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i+1;
                y1=j-2;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i-1;
                y1=j-2;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i-2;
                y1=j-1;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
                x1=i-2;
                y1=j+1;
                if(1<=x1&&x1<=8&&1<=y1&&y1<=8)
                {
                    n=(x1-1)*8+y1;
                    matrix[m][n]=1;//matrix[n][m]=1;
                }
            }
        }
        return matrix;
    }
    
    public static int getNode(String s)
    {
        int x=s.charAt(0)-'a'+1;
        int y=s.charAt(1)-'0';
        return (x-1)*8+y;
    }
    
    public static int shortestRoute(int [][] arr, int start, int end)
    {
        if(start==end)
        {
//            System.out.println("Total Bridges: 0\nPath: "+start);
            return 0;
        }
        //The above if(){...} code is redundant but added for edge case handling purpose
        //You can comment the above code and yet the program would run still fine!
        
        int []queue=new int[arr.length];
        int []parent=new int[arr.length];
        int []visitingRecord=new int[arr.length];
        int current=1, count=1;
        boolean found=false;
        queue[1]=start;
        visitingRecord[start]=1;
        
        while(current<arr.length&&!found)
        {
            for(int i=1;i<arr[queue[current]].length;i++)
            {
                if(arr[queue[current]][i]==1)
                {
                    if(visitingRecord[i]==0)
                    {
                        visitingRecord[i]=1;
                        count++;
                        queue[count]=i;
                        parent[count]=current;
                        if(queue[count]==end)
                        {
                            found=true;
                            break;
                        }
                    }
                }
            }
            current++;
        }
        
        int bridgeCount=0;
        int p=count;
        String s="";
        while(p!=1)
        {
            s="->"+queue[p]+s;
            p=parent[p];
            bridgeCount++;
        }
        return bridgeCount;
//        System.out.println("Total Bridges: " + bridgeCount );
//        s=queue[p]+s;
//        System.out.println("Path: " + s);
    }
    
}
