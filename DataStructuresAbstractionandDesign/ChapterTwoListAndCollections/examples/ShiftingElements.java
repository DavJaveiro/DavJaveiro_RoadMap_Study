import java.util.Arrays;

public class ShiftingElements {
    public static void main(String args[]) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("Array original: " + Arrays.toString(numbers));
        
        // Guardar o primeiro elemento ANTES de modificar
        int primeiroElemento = numbers[0];
        
        // Mover todos os elementos para a esquerda
        // Começando do segundo elemento (índice 1)
        for (int i = 1; i < numbers.length; i++) {
            numbers[i - 1] = numbers[i];
        }
        
        // Colocar o primeiro elemento no final
        numbers[numbers.length - 1] = primeiroElemento;
        
        System.out.println("Após mover para esquerda: " + Arrays.toString(numbers));
        // Saída: [2, 3, 4, 5, 1]
    }
}