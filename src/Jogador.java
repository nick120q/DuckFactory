public class Jogador {

    private String nome;
    private double saldo;

    public Jogador(String nome) {
        this.nome = nome;
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
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
}