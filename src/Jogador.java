public class Jogador {
    private String nome;
    private double saldo;
    private int pontosMisticos;

    public Jogador(String nome, double saldo, int pontosMisticos) {
        this.nome = nome;
        this.saldo = 0;
        this.pontosMisticos = pontosMisticos;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getPontosMisticos() {
        return pontosMisticos;
    }

    public void adicionarDinheiro(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean gastarDinheiro(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }

        return false;
    }

    public void mostrarStatus() {
        IO.println("Pato " + nome);
        IO.println("Dinheiro: " + saldo);
    }
}
