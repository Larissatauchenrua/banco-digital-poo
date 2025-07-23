public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital da Larissa");

        Cliente venilton = new Cliente("Venilton");
        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        try {
            cc.depositar(200);
            cc.sacar(50);
            cc.transferir(500, poupanca); // Vai lançar SaldoInsuficienteException
		}catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Erro bancário: " + e.getMessage());
        }

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
