public class IndexedSumvsEnhanced2601{
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(indexed(nums));
        System.out.println(forEach(nums));
    }

    public static int indexed(int[] array) {
        int soma = 0;
        for (int i = 0; i < array.length; i++) if (i % 2 == 0)soma += array[i];
        return soma;
    }

    public static int forEach(int[] array) {
        int soma = 0;
        int contador = -1;
        for (int numbers : array) {
            contador += 1;
            if (contador % 2 == 0)
                soma += numbers;
        }
        return soma;
    }
}