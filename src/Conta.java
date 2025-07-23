public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo; // <- ESSA LINHA É ESSENCIAL

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor do saque deve ser maior que zero.");
        }
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor do depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void transferir(double valor, Conta destino) {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor da transferência deve ser maior que zero.");
        }
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void imprimirExtrato() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.printf("Saldo: %.2f%n", saldo);
        System.out.println();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}