import exceptions.Invalido;
import exceptions.SaldoInsuficiente;

public interface InterfaceConta {

    public abstract void sacar(int valor) throws SaldoInsuficiente, Invalido;

//Para depositar a regra de negócio é que ele sempre irá depositar um valor em sua conta
    public void depositar(int valor);

//Para transferir a regra de negócio é transferir para qualquer pessoa e esse valor será retirado de sua conta
    public void transferir(InterfaceConta contaDeTransferência, int valor) throws SaldoInsuficiente, Invalido;

    public double consultarSaldo();

    public String imprimirExtrato();

}
