public class Numero implements Comparable<Numero>{
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int compareTo(Numero outro) {
        return Integer.compare(this.valor, outro.valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    
}
