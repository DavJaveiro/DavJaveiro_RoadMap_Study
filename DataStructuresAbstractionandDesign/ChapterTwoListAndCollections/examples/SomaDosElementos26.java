import java.util.ArrayList;
import java.util.List;

public class SomaDosElementos26 {
    public static void main(String args[]) {
        ArrayList<Integer> arrayNumbers = new ArrayList<>(
            List.of(10, 100)
        );

    System.out.println(somaElementos(arrayNumbers));

    }

    public static int somaElementos(ArrayList<Integer> list){
        int somaTotal = 0;
        for(int i = 0; i < list.size(); i++) {
            somaTotal += list.get(i);
        }
        return somaTotal;
    }

}
