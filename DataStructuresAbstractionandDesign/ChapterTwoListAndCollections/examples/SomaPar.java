import java.util.ArrayList;
import java.util.List;

public class SomaPar{
    public static void main(String args[]) {
        ArrayList<Double> myList = new ArrayList<>(
            List.of(1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5)
        );

        Double listaSomada = somaParAprimorado(myList);
        System.out.println(listaSomada);
    }

    public static Double somaParAprimorado(ArrayList<Double> listNumerosDois) {
        Double total = 0.0;
        int indexContador = -1;
        for (Double numbers : listNumerosDois) {
            indexContador += 1;
            if(indexContador % 2 == 0 && indexContador != 0) {
                total += numbers;
            }
        }
        return total;
    }
}