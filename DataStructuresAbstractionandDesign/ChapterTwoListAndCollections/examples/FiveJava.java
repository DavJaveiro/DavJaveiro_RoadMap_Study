import java.util.ArrayList;
import java.util.List;

public class FiveJava {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        
        for (int i = numbers.size() -1, j = 0; i >= 0 && j <= numbers.size()-1; i--, j++) {
            while (numbers.get(i) > numbers.get(j)) {
                numbers.add(i);
            } 

            
        }
    }
}
