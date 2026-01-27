import java.util.ArrayList;
import java.util.List;

public class Ocurrer2701 {
    public static void main(String args[]) {
        ArrayList<String> wordsSample = new ArrayList<>(
            List.of("Java", "Python", "Java", "Go", "Java")
        );

        System.out.println(contadorOcorr(wordsSample, "Go"));
    }

    public static int contadorOcorr(ArrayList<String> palavras, String alvo) {
        int contador = 0;
        
        for (String words : palavras) {
            if (alvo == words) {
                contador += 1;
            }
        }

        return contador;
    }

}
