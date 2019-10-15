import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader; 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Problem1146b {

    public static void main(String[] args) throws IOException {

        //InputStreamReader isr = new InputStreamReader(System.in);
        //BufferedReader in = new BufferedReader(isr);
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int digitado = 1;
        while(digitado != 0){
            digitado = Integer.parseInt(in.readLine());

            for (int i = 0; i < digitado; i++) {
                if (i + 1 == digitado) {
                    System.out.print(i + 1); //Aqui removo e espaço após o último número da sequência
                }else{
                    System.out.print(i + 1 + " ");
                }

            }
            System.out.println();
        }

    }

}