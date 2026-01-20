import java.util.ArrayList;
import java.util.Scanner;

public class DesafioOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro:");
        int n = scanner.nextInt();
    
        ArrayList<Integer> numeros = returnNewArray();
        for ( int i = 1; i <= n; i++) {
            numeros.add(i);
        }
        System.out.println(numeros);
    }

    private static ArrayList<Integer> returnNewArray() {
        ArrayList<Integer> numbers = new ArrayList<>();
        return numbers;
    }
}
