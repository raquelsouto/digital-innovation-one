package exceptions;

public class SaldoInsuficiente extends Exception {

    private double valor = 0;

    public SaldoInsuficiente(String error) {
        super(error);
    }

    public SaldoInsuficiente(String error, double valor) {
        super(error);
        this.valor = valor;
    }
}
