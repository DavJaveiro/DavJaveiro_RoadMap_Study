import java.util.ArrayList;
import java.util.List;

public class Four2301 {

    public static void main(String args[]) {
        ArrayList<String> arrayString = new ArrayList<>(
            List.of(
                "Java",
                "Python",
                "Java",
                "Go",
                "C++",
                "Java"
            )
        );
        String wordTarget = "Java"; 
        System.out.println(quantasVezesPalavra(arrayString, wordTarget ));

    }

    public static int quantasVezesPalavra(ArrayList<String> listaPalavras, String targetWord) {
        int contador = 0;
        for(String words : listaPalavras) {
            if(words.equals(targetWord)){
                contador += 1;
            }
        }

        return contador;
    }
}


