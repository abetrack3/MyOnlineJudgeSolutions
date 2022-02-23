import java.util.Scanner;
class CodeForces1644A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.nextLine();
        while (test --> 0) {
            char[] arr = scanner.nextLine().toCharArray();
            boolean red = false, blue = false, green = false, ans = true;
            for(char c : arr) {
                switch (c) {
                    case 'r':red=true;break;
                    case 'g':green=true;break;
                    case 'b':blue=true;break;
                    case 'R': if(!red) ans = false;break;
                    case 'G': if(!green) ans = false;break;
                    case 'B': if(!blue) ans = false;break;
                }
            }
            System.out.println((ans)?"YES":"NO");
        }
    }
}