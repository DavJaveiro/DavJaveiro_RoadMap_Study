import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exampleOne {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um valor que gostaria que criássemos um array:");
        int entrada = sc.nextInt();

        var list = createListNumber(entrada);
        System.out.println(list);

    }

    public static List<Integer> createListNumber(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }
    
}
