import java.util.ArrayList;
import java.util.List;

public class Three {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        
        ArrayList<Integer> newNumbers = new ArrayList<>();
        
        for(int i = numbers.size() -1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            } else {
                newNumbers.add(numbers.get(i));
            }
         }
         
        System.out.println("Números ímpares: " + newNumbers);

    }
    

}
