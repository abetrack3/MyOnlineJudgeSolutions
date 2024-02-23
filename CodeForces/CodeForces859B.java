import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            int blocks = sc.nextInt();

            double base = (int)Math.ceil(Math.sqrt(blocks));
            double height = Math.ceil(blocks / base);
            int permieter = (int)(2 * (base + height));
            System.out.println(permieter);

        }

    }

}
