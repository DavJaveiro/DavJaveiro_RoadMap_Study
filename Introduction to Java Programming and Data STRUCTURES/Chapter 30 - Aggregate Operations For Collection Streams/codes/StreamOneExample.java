
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StreamOneExample {

    public static void main(String[] args) {
        Double[] number = {2.4, 55.6, 90.12, 26.6};
        Set<Double> set = new HashSet<>(Arrays.asList(number));
        
    
        long count = set.stream().filter(e -> e > 60).count();
        
        System.out.println(count);
    }


}
