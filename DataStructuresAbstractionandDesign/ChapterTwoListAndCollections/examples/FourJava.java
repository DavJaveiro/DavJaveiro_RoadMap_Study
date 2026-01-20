import java.util.ArrayList;
import java.util.List;

public class FourJava {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(
                List.of("Java", "Python", "Go", "JavaScript", "Java", "Java", "Go"));

        int contagem = contador(words, "Go");
        System.out.println(contagem);       
    }

    private static int contador(ArrayList<String> palavras, String alvo) {
        int contagem = 0;
        for(int i = 0; i <= palavras.size() -1; i++) {
            if(palavras.get(i).equals(alvo)) {
                contagem += 1;
            }
        }
        return contagem;
    }
}
