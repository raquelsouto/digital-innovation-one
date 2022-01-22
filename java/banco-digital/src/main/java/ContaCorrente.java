import exceptions.Invalido;
import exceptions.SaldoInsuficiente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ContaCorrente extends Conta {

    protected static final double JUROS_CC = 1.5;

    public ContaCorrente(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }

    @Override
    public void sacar(int valor) throws SaldoInsuficiente, Invalido {
        if(super.getSaldo() > valor && valor > 0) {
            double saldo = super.getSaldo() - (valor + JUROS_CC);
            super.setSaldo(saldo);
        } else if(super.getSaldo() < valor) {
            throw new SaldoInsuficiente("Saldo insuficiente!");
        } else if(valor < 0) {
            throw new Invalido("Transferência inválida!");
        }
    }

    @Override
    public String imprimirExtrato() {
        System.out.println("Extrato Conta Corrente.. ");
        String out = null;
        out = "Agencia: " + agencia + "\n";
        out+= "Numero: " + numero + "\n";
        out+= "Saldo R$ " + saldo + "\n";
        return out;
    }

}

