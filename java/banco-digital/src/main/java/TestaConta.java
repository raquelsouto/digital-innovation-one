import exceptions.Invalido;
import exceptions.SaldoInsuficiente;

public class TestaConta {

    public static void main(String[] args) throws Invalido, SaldoInsuficiente {

        System.out.println("Criando um cliente..\n");
        Cliente cliente1 = new Cliente("Raquel Winkeler", "123654789-10");

        System.out.println("Criando uma conta corrente para o cliente: " + cliente1.getNome() + "\n");
        Conta cc1 = new ContaCorrente(2500.29, cliente1);

        System.out.println("Criando uma conta poupança para o cliente: " + cliente1.getNome() + "\n");
        ContaPoupanca cp1 = new ContaPoupanca(120, cliente1);

        System.out.println("Informações do Cliente 1\n");

        System.out.println("Saldo atual Conta Corrente R$ " + cc1.getSaldo());

        System.out.println("Sacando R$ 500 + R$ 1.50 de juros..");
        cc1.sacar(500);
        System.out.println("Saldo atual R$ " + cc1.getSaldo());

//        System.out.println("\nTentando sacar mais do que o saldo disponível na conta");
//        cc1.sacar(3000);

        System.out.println("\nSaldo atual R$ " + cc1.getSaldo());
        System.out.println("Depositando R$ 1000..");
        cc1.depositar(1000);
        System.out.println("Saldo atual R$ " + cc1.getSaldo() + "\n");

        System.out.println("Transferindo R$ 200 para a conta poupança..");
        System.out.println("Saldo atual Conta Poupança R$ " + cp1.getSaldo());
        cc1.transferir(cp1, 200);
        System.out.println("Saldo atual da Conta Poupança R$ " + cp1.getSaldo() + "\n");

        cp1.depositar(35);
        System.out.println("Saldo atual da Conta Poupança R$ " + cp1.getSaldo());

//        System.out.println("Tentando tranferir mais do que o saldo disponível..");
//        cp1.transferir(cc1, 800);

        String extrato = cc1.imprimirExtrato();
        System.out.println(extrato);
    }

}
