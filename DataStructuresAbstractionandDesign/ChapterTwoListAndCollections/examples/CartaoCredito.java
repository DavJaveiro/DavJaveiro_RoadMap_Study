public class CartaoCredito implements Pagamento {
    private String numero;
    private String titular;
    private String validade;

    public CartaoCredito(String numero, String titular, String validade) {
        this.numero = numero;
        this.titular = titular;
        this.validade = validade;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com cartão de crédito " + numero);
    }

}
