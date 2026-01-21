import java.util.ArrayList;
import java.util.List;

public class ElementsSum {
    public static void main(String args[]) {
        ArrayList<Double> myList = new ArrayList<>(
            List.of(1.5, 1.5, 1.5, 1.5, 1.5)
        );

        Double somado = calculaIndicesPar(myList);
        System.out.println(somado);
    }

    public static Double calculaIndicesPar(ArrayList<Double> listaNumeros) {
        Double soma = 0.0;
        for(int i = 0; i < listaNumeros.size(); i++) {
            if(i % 2 == 0 & i != 0) {
                soma += listaNumeros.get(i);
            }
        }
        return soma;
    }

}
