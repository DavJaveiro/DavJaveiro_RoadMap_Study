import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class SomaPar{
    public static void main(String args[]) {
        ArrayList<Double> myList = new ArrayList<>(
            List.of(1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5)
        );

        Double listaSomada = somaParAprimorado(myList);
        System.out.println(listaSomada);
    }

    public static Double somaIndicePar(ArrayList<Double> listaNumeros) {
        Double total = 0.0;
        for (int i = 0; i < listaNumeros.size(); i++){
            if (i % 2 == 0 && i != 0) {
                total += listaNumeros.get(i);
            }
        }
        return total;
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