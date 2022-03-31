/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abetrack3
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
 
public class CodeForces1343B
{
    
    public static StringBuilder ans;
    public static boolean flag = true;
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        int q = Integer.parseInt(br.readLine());
        while (q-->0)
        {
            int t = Integer.parseInt(br.readLine());
            if(t/2 % 2 == 0)
            {
                solve2(t);
                out.write(("YES\n"+ans+"\n").getBytes());
            }
            else out.write("NO\n".getBytes());
        }
        out.flush();
    }
    
    public static void solve(int t)
    {
        ans = new StringBuilder();
        flag = true;
        long sum = 0;
        for(int i = 1; i <= t/2; i++)
        {
            ans.append(2*i+" ");
            sum += 2*i;
        }
        permute(1, sum, "", 0, t, 0);
    }
    
    public static void solve2(int t)
    {
        ans = new StringBuilder();
        long sum = 0;
        for(int i = 1; i <= t/2; i++)
        {
            ans.append(2*i+" ");
            sum += 2*i;
        }
        sum--;
        ans.append(1 + " ");
        for(int i = 1; i < t/2 - 1; i++)
        {
            ans.append(1 + 2 * i + " ");
            sum -= 1 + 2 * i;
        }
        ans.append(sum);
    }
    
    public static void permute(int odd, long limit, String s, long sum, int t, int depth)
    {
        if(sum > limit) return;
        if(depth >= t/2) return;
//        if(odd > t) return;
        for(int i = odd; i < limit && flag; i += 2)
        {
            if(odd + sum == limit)
            {
                ans.append(s+" "+odd);
                flag = false;
                return;
            }
            else permute(i + 2, limit, (odd == 1)?"1":s+" "+odd, odd + sum, t, depth + 1);
        }
    }
    
}
