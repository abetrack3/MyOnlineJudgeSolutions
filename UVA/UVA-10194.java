import java.util.Scanner;
import java.io.*;
public class Main
{
    public static void main (String[]args) throws Exception
    {
//        Scanner puttingvaluesinside=new Scanner(System.in);
        Scanner puttingvaluesinside = new Scanner(System.in, "ISO-8859-1");
        System.setOut(new PrintStream(System.out, true, "ISO-8859-1"));
        int t=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
//        for(;t>0;t--)
        while(t-->0)
        {
            String tournament=puttingvaluesinside.nextLine();
            Team [] arr=new Team[puttingvaluesinside.nextInt()];
            puttingvaluesinside.nextLine();
            for(int i=0;i<arr.length;i++)
                arr[i]=new Team(puttingvaluesinside.nextLine());//.trim());
            int n=puttingvaluesinside.nextInt();
            puttingvaluesinside.nextLine();
            for(int j=0;j<n;j++)
            {
                String s1[]=puttingvaluesinside.nextLine().split("#", 3);
                String s2[]=s1[1].split("@", 2);
                int g1=Integer.parseInt(s2[0]);
                int g2=Integer.parseInt(s2[1]);
                for(int i=0;i<arr.length;i++)
                {
//                    if(s1[0].trim().equals(arr[i].name))
                    if(s1[0].equals(arr[i].name))
                    {
                        if(g1==g2)
                            arr[i].tie(g1, g2);
                        else if(g1>g2)
                            arr[i].win(g1, g2);
                        else
                            arr[i].loss(g1, g2);
                        break;
                    }
                }
                for(int i=0;i<arr.length;i++)
                {
                    if(s1[2].equals(arr[i].name))
                    {
                        if(g1==g2)
                            arr[i].tie(g2, g1);
                        else if(g1>g2)
                            arr[i].loss(g2, g1);
                        else
                            arr[i].win(g2, g1);
                        break;
                    }
                }
            }
            sort(arr);
            System.out.println(tournament);
            for(int i=0;i<arr.length;i++)
                    System.out.println(i+1+") "+arr[i]);
            if(t>0) System.out.println();
        }
        // System.out.println();
    }
    
    public static void sort(Team []arr)
    {
        for(int i=arr.length-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j].points==arr[j+1].points)
                    mostWins(arr, j, j+1);
                else if(arr[j].points<arr[j+1].points)
                    swap(arr, j, j+1);
            }
        }
    }
    public static void swap(Team [] arr, int a, int b)
    {
        Team temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void mostWins(Team  [] arr, int a, int b)
    {
        if(arr[a].wins==arr[b].wins)
        {
            if((arr[a].goalsGained-arr[a].goalsLost)==(arr[b].goalsGained-arr[b].goalsLost))
            {
                if(arr[a].goalsGained==arr[b].goalsGained)
                {
                    if(arr[a].gameCount==arr[b].gameCount)
                    {
                        if((arr[a].name.toUpperCase()).compareTo(arr[b].name.toUpperCase())>0)
                            swap(arr, a, b);
//                        System.out.println(arr[a].name.toUpperCase());
//                        System.out.println(arr[a].name.toUpperCase());}
                    }
                    else if(arr[a].gameCount>arr[b].gameCount)
                        swap(arr, a, b);
                }
                else if(arr[a].goalsGained<arr[b].goalsGained)
                    swap(arr, a, b);
            }
            else if((arr[a].goalsGained-arr[a].goalsLost)<(arr[b].goalsGained-arr[b].goalsLost))
                swap(arr, a, b);
        }
        else if(arr[a].wins<arr[b].wins)
            swap(arr, a, b);
    }
}

class Team
{
    String name;
    int points, wins, ties, losses, gameCount, goalsGained, goalsLost;
    public Team(String s)
    {
        name=s;
        points=wins=ties=losses=gameCount=goalsGained=goalsLost=0;
    }
    public void win(int u, int d)
    {
        points+=3;
        wins++;
        gameCount++;
        goalsGained+=u;
        goalsLost+=d;
    }
    public void tie(int u, int d)
    {
        points+=1;
        ties++;
        gameCount++;
        goalsGained+=u;
        goalsLost+=d;
    }
    public void loss(int u, int d)
    {
        losses++;
        gameCount++;
        goalsGained+=u;
        goalsLost+=d;
    }
    public String toString()
    {
        return name+" "+points+"p, "+gameCount+"g ("+wins+"-"+ties+"-"+losses+"), "+(goalsGained-goalsLost)+"gd ("+goalsGained+"-"+goalsLost+")";
    }
}