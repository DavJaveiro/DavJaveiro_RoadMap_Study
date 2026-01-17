
import java.util.ArrayList;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        ArrayList<Integer> numberIntegers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for(int y = 0; y <= n; y++) {
            numberIntegers.add(y);
            System.out.println(numberIntegers);
        }


        int total = 0;
        for (int i = 0; i <= numberIntegers.size() -1; i++) {
            Integer numbers  = numberIntegers.get(i);
            total = total + numbers;
            System.out.println("Soma dos números: " + total); 
        }
        System.out.println(total);
    }

}