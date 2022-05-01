

import java.util.Scanner;
import java.lang.StringBuilder;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int max;
        if (n%2 == 0){
            max = n*n/2;
        }
        else max = n*n/2 + 1;
        
        if (k > max){
            System.out.println("NO");
        }
        else{
            int count=0;
            System.out.println("YES");
            for (int i=0; i!=n; i+=1){
                for (int j=0; j!=n; j+=1){
                    if ((i%2 == 0 && j%2 == 0 && (count<k)) || (i%2 == 1 && j%2 == 1 && (count<k))){ sb.append('L'); count++;}
                    else sb.append('S');
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
    
        }
        
    }
    
    
    }

