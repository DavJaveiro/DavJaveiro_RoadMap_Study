import java.util.ArrayList;
import java.util.List;

public class FourJava {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(
                List.of("Java", "Python", "Go", "JavaScript", "Java", "Java"));
        
        String alvo = "Java";
        
        int contagem = 0;
        for(int i = 0; i < words.size()-1; i++) {
            if(words.get(i).equals(alvo)){
                contagem += 1;
            }
        }

        System.out.println("O número de vezes que aparece é: " + contagem);
    }

}
