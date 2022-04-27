import java.util.Scanner;
 
public class CodeForces_1617_A{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.nextLine();
        while(test --> 0){
            char[] s = scanner.nextLine().toCharArray();
            String t = scanner.nextLine();
            int[] counter = new int[26];
            for(char x : s)
                counter[(int)x - 97] += 1;
            StringBuilder sb = new StringBuilder();
            //add character a
            int temp = counter[0];
            while(temp --> 0)
                sb.append('a');
            //adding c before b if t is lexicgraphically the lowest subsequence
            if(t.equals("abc") && !(counter[0] == 0 || counter[1] == 0 || counter[2] == 0)){
                while(counter[2] --> 0)
                    sb.append('c');
            }
            char ch = 'b';
            for(int i = 1; i < counter.length; i++, ch++){
                while(counter[i] --> 0)
                    sb.append(ch);
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }
}