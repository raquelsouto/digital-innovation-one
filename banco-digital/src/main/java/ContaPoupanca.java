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
public class ContaPoupanca extends Conta {

    private static final double JUROS_CP = 2.5;

    public ContaPoupanca(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }

    @Override
    public void sacar(int valor) throws SaldoInsuficiente, Invalido {
        if(super.getSaldo() > valor && valor > 0) {
            double saldo = super.getSaldo() - (valor + JUROS_CP);
            super.setSaldo(saldo);
        } else if(super.getSaldo() < valor) {
            throw new SaldoInsuficiente("Saldo insuficiente!");
        } else if(valor < 0) {
            throw new Invalido("Transferência inválida!");
        }
    }

    @Override
    public String imprimirExtrato() {
        System.out.println("Extrato Conta Poupança..");
        String out = null;
        out= "Agencia: " + agencia + "\n";
        out+= "Numero: " + numero + "\n";
        out+= "Saldo R$ " + saldo + "\n";
        return out;
    }
}
