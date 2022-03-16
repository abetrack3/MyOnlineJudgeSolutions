/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abrarshahriar
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class CodeForces1324C
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            char c[] = ("R"+br.readLine()).toCharArray();
            int d = 1;
            int temp = 0;
            for(int i = c.length-1 ; i>=0 ; i--)
            {
                if(c[i] == 'R')
                {
                    temp++;
                    d = (temp>d)? temp : d;
                    temp = 0;
                }
                else
                    temp++;
            }
            System.out.println(d);
        }
    }
}
