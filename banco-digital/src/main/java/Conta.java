import exceptions.Invalido;
import exceptions.SaldoInsuficiente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
public abstract class Conta implements InterfaceConta {

    private static final Logger log = Logger.getLogger(InterfaceConta.class.getName());
    private static final int AGENCIA_PADRAO = 0022;
    private static final double JUROS_CONTA = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public Conta(double saldo, Cliente cliente) {
        this();
        this.saldo = saldo;
        this.cliente = cliente;
    }

    @Override
    public void sacar(int valor) throws SaldoInsuficiente, Invalido {
        if(this.saldo > valor && valor > 0) {
            this.saldo -= (JUROS_CONTA + valor);
        } else if(saldo < valor) {
            log.warning("Erro na transferência. Saldo inválido!");
            throw new SaldoInsuficiente("Saldo insuficiente!");
        } else if(valor > 0) {
            log.warning("Valor não permitido!");
            throw new Invalido("Transferência inválida!");
        }
    }

    @Override
    public void depositar( int valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(InterfaceConta contaDestinoTransferencia, int valor) throws SaldoInsuficiente, Invalido {
        this.sacar(valor);
        contaDestinoTransferencia.depositar(valor);
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }
}
