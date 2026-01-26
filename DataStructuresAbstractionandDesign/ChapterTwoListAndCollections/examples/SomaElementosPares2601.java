import java.util.ArrayList;
import java.util.List;

// Levei 7 minutos hoje, dia 26/01/2026
public class SomaElementosPares2601 {
    public static void main(String args[]) {
        ArrayList<Integer> arrayNumbers = new ArrayList<>(
            List.of(2, 1, 2)
        );

        System.out.println(resultadoSoma(arrayNumbers));
        
        int[] numbersArray = new int[5];
        System.out.println(numbersArray[1]);
        
    }

    public static int resultadoSoma(ArrayList<Integer> arrayNumberss) {
        int totalSomaIndices = 0;

        for (int i = 0; i < arrayNumberss.size(); i++) {
            if(i % 2 == 0) {
                totalSomaIndices += arrayNumberss.get(i);
            }
        }

        return totalSomaIndices;
    }


}
