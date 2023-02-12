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
import java.util.HashMap;

public class Main
{
    
    public static HashMap<key, Integer> cache = new HashMap<key, Integer>();
    public static int arr[];// = {1, 5, 5};//{4, 4, 2, 1, 3, 2, 1};
    
    public static void main(String[] args)
    {
        run();
        System.out.println(run2(0, arr.length - 1, 1));
//        test();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        arr = new int[sc.nextInt()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
    }
    
    public static long run1()
    {
        int left = 0, right = arr.length - 1, day = 1;
        long sum = 0;
        while (left <= right)
        {
            if(left == right)
            {
                sum += day * arr[left];
                break;
            }
            int dir;
            if(arr[left] == arr[right]) dir = 0;
            else if (arr[left] < arr[right]) dir = -1;
            else dir = 1;
            
            if(dir == 0)
            {
                int l = left, r = right;
                while (l < r)
                {
                    if(arr[l] != arr[r])
                    {
                        dir = (arr[l] < arr[r]) ? -1 : 1;
                        break;
                    }
                    l++;
                    r--;
                }
            }
            if(dir == -1 || dir == 0)
            {
                sum += day * arr[left];
                left++;
            }
            else
            {
                sum += day * arr[right];
                right--;
            }
            
            
            day++;
        }
        return sum;
    }
    
    public static int run2(int left, int right, int day)
    {
        if(left > right) return 0;
        if(left == right) return day * arr[left];
        key x = new key(left, right, day);
        if(cache.containsKey(x)) return cache.get(x);
        else
        {
            int a = day * arr[left] + run2(left + 1, right, day + 1);
            int b = day * arr[right] + run2(left, right - 1, day + 1);
            cache.put(x, Math.max(a, b));
            return Math.max(a, b);
        }
    }
    
    public static long bruteForce(int left, int right, int day)
    {
        if(left > right) return 0;
        if(left == right) return day * arr[left];
        long a = day * arr[left] + bruteForce(left + 1, right, day + 1);
        long b = day * arr[right] + bruteForce(left, right - 1, day + 1);
        return Math.max(a, b);
    }
    
    public static void test()
    {
        while (true)
        {
//            arr = new int[(int)(Math.random() * 8)];
//            for(int i = 0; i < arr.length; i++)
//                arr[i] = (int)(Math.random() * 5 + 1);
            long run2 = run2(0, arr.length - 1, 1);
            long bruteForce = bruteForce(0, arr.length - 1, 1);
            if(run2 != bruteForce)
            {
                System.out.println("Mismatch found!!!");
                System.out.println(java.util.Arrays.toString(arr));
                System.out.println("run2 = " + run2);
                System.out.println("bruteForce = " + bruteForce);
                break;
            } else System.out.println("Hope");
        }
    }
    
    static class key
    {
        int a, b, c;
        key(int d, int e, int f)
        {
            a = d;
            b = e;
            c = f;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 31 * hash + this.a;
            hash = 31 * hash + this.b;
            hash = 31 * hash + this.c;
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            final key other = (key) obj;
            if (this.a != other.a)
            {
                return false;
            }
            if (this.b != other.b)
            {
                return false;
            }
            if (this.c != other.c)
            {
                return false;
            }
            return true;
        }
    }
    
}
