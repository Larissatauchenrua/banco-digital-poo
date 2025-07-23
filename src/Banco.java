import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }
}
