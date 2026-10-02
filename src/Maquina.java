public abstract class Maquina {
    private String nome;
    private int nivel;
    private double dinheiroPorCiclo;
    private double tempoProducao;

    private boolean produzindo;
    private long inicioProducao;

    public Maquina(String nome, double dinheiroPorCiclo, double tempoProducao) {
        this.nome = nome;
        this.nivel = 1;
        this.dinheiroPorCiclo = dinheiroPorCiclo;
        this.tempoProducao = tempoProducao;
        this.produzindo = false;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public double getDinheiroPorCiclo() {
        return dinheiroPorCiclo;
    }

    public double getTempoProducao() {
        return tempoProducao;
    }

    public boolean isProduzindo() {
        return produzindo;
    }

    public void ativar() {
        if (produzindo) {
            IO.println("A máquina já está produzindo!");
            return;
        }

        inicioProducao = System.currentTimeMillis();
        produzindo = true;

        IO.println(nome + " foi ativada!");
    }

    public boolean terminou() {
        if (!produzindo) {
            return false;
        }

        long tempoPassado = System.currentTimeMillis() - inicioProducao;
        long tempoNecessario = (long) (tempoProducao * 1000);

        return tempoPassado >= tempoNecessario;
    }

    public double coletar() {
        if (!terminou()) {
            return 0;
        }

        produzindo = false;
        return produzir();
    }

    public double tempoRestante() {
        if (!produzindo) {
            return 0;
        }

        long tempoPassado = System.currentTimeMillis() - inicioProducao;
        long tempoNecessario = (long) (tempoProducao * 1000);

        long restante = tempoNecessario - tempoPassado;

        if (restante <= 0) {
            return 0;
        }
        return restante / 1000.0;
    }


    public void melhorar() {
        nivel++;

        dinheiroPorCiclo *= 1.25;
        tempoProducao *= 0.90;

        IO.println(nome + " melhorada para o nível " + nivel + "!!!");
    }

    public abstract double produzir();
}