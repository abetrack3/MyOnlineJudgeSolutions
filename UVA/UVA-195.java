/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main
{
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            String s = br.readLine();
            solve(s);
        }
    }
    
    public static void solve(String s) throws Exception
    {
        char c[] = s.toCharArray();
        HashSet <Integer> positions = new HashSet<Integer>();
        HashSet <String> ans = new HashSet<String>();
        for (int i = 0; i < c.length; i++)
            positions.add(i);
        permute("", c, positions, ans);
        String arr[] = new String[ans.size()];
        ans.toArray(arr);
//        java.util.Arrays.sort(arr);
        Element []arr2 = new Element[arr.length];
        for (int i = 0; i < arr.length; i++)
            arr2[i] = new Element(arr[i]);
        arr2 = mergeSort(arr2);
        StringBuilder sb = new StringBuilder();
        for(Element x:arr2)
        {
//            System.out.println(x);
            sb.append(x+"\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void permute(String s, char c[], HashSet <Integer>positions,HashSet<String>ans )
    {
        if (positions.size() == 0)
        {
            ans.add(s);
            return;
        }
        HashSet<String> characters = new HashSet<String>();
        for(int i = 0; i < c.length; i++)
        {
            if(positions.contains(i))
            {
                if(characters.contains(""+c[i]))
                    continue;
                else
                    characters.add(""+c[i]);
                //the above four lines of if-else condition is the key
                //to reduce complexity
                positions.remove(i);
                permute(s+c[i], c, positions, ans);
                positions.add(i);
            }
        }
    }
    
    public static Element[] //changes
        mergeSort(Element [] arr) //changes
    {
        if(arr.length==1)
            return arr;
        if(arr.length==2)
        {
//            if(arr[1]<arr[0])
            if(compare(arr[1], arr[0]) == -1)
            {
                Element temp=arr[0]; //changes
                arr[0]=arr[1];
                arr[1]=temp;
            }
            return arr;
        }
        int left=arr.length/2;
        Element arrL[]=new Element[left]; //changes
        for(int i=0;i<left;i++)
            arrL[i]=arr[i];
        Element arrR[]=new Element[arr.length-left]; //changes
        for(int i=left;i<arr.length;i++)
            arrR[i-left]=arr[i];
        return mergeArray(mergeSort(arrL), mergeSort(arrR));
    }
    
    private static Element[] //changes
        mergeArray(Element []arr1, Element []arr2) //changes
    {
        int a=0, b=0;
        Element arr[]=new Element[arr1.length+arr2.length]; //changes
        for(int i=0;i<arr.length;i++)
        {
            if(a<arr1.length&&b<arr2.length)
            {
//                if(arr1[a]<arr2[b])
                if(compare(arr1[a], arr2[b]) == -1)
                {
                    arr[i]=arr1[a];
                    a++;
                }
                else
                {
                    arr[i]=arr2[b];
                    b++;
                }
            }
            else if(a<arr1.length)
            {
                arr[i]=arr1[a];
                a++;
            }
            else if(b<arr2.length)
            {
                arr[i]=arr2[b];
                b++;
            }
        }
        return arr;
    }
    
    private static int compare(Element a, Element b)
    {
        if(!a.v.equals(b.v))
        {
            char c[] = a.v.toCharArray();
            char d[] = b.v.toCharArray();
            for(int i = 0; i < c.length; i++)
            {
                if(c[i] == d[i]) continue;
                else
                {
                    int e = (c[i]>='a' && c[i]<='z')?c[i]-97:c[i]-65; 
                    int f = (d[i]>='a' && d[i]<='z')?d[i]-97:d[i]-65;
                    // a A
                    if (e == f)
                    {
                        if (c[i] < d[i]) return -1;
                        else return +1;
                    }
                    else
                    {
                        if (e < f) return -1;
                        else return +1;
                    }
                }
            }
        }
        return 0;
    }
    
    static class Element
    {
        String v;

        Element(String val)
        {
            v = val;
        }

        public String toString()
        {
            String s;
            s = ""+v;
            return s;
        }

    }
    
}
