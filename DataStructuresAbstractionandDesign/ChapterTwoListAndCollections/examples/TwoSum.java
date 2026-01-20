
import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbersForSum = new ArrayList<>(
            List.of(1, 2, 3, 4)
        );

        int total = realizaSoma(numbersForSum);
        
        System.out.println(total);
    }

    private static int realizaSoma(ArrayList<Integer> numbersIn) {
        int total = 0;
        for(int i = 0; i <= numbersIn.size() -1; i++) {
            Integer numbers = numbersIn.get(i);
            total = total + numbers;
        }
        return total;
    }
}