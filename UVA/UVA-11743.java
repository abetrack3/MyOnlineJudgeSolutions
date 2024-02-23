/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abrarshahriar
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        while(t-->0)
        {
            String s = "";
            s+=puttingvaluesinside.next();
            s+=puttingvaluesinside.next();
            s+=puttingvaluesinside.next();
            s+=puttingvaluesinside.next();
            char c[] = s.toCharArray();
            int sum = 0;
            for(int i=1;i<c.length;i+=2)
                sum+=c[i]-'0';
            String s2 = "";
            for(int i=14;i>=0;i-=2)
                s2+=(c[i]-'0')*2;
            c = s2.toCharArray();
            for(char x:c)
                sum+=x-'0';
            System.out.println((sum%10==0)?"Valid":"Invalid");
        }
    }
}
