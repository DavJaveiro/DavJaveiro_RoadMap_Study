import java.util.ArrayList;
import java.util.List;

public class ContadorVezes2801 {
    public static void main(String[] args) {
        ArrayList<String> listWord = new ArrayList<>(
            List.of("Java", "Python", "Java")
        );

        System.out.println(contadorVezes(listWord, "Java"));
    }

    public static int contadorVezes(ArrayList<String> arrayList, String alvo) {
        int contador = 0;
        for (String words : arrayList) {
            if (words == alvo)
                contador += 1;
        }
        return contador;
    }
}
