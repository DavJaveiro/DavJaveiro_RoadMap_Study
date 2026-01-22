
public class IndexedSum2201 {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(soma(nums));
    }    

    public static int soma(int[] array) {
        int resultadoSoma = 0;
        int contador = -1;

        for(int numbers : array) {
            contador += 1;
            if(contador % 2 == 0) {
                resultadoSoma += numbers;
            }
        }
        return resultadoSoma;
    }
}
