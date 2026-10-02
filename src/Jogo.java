import java.util.Scanner;

public class Jogo {
    private PatoPresidente presidente = new PatoPresidente();
    private PatoDeus deus = new PatoDeus();

    private Scanner sc = new Scanner(System.in);

    private Jogador jogador;
    private MaquinaPatinhos maquinaPatinhos;

    private void mostrarMenu() {
        System.out.println("╔════════════════════╗");
        System.out.println("     DUCK FACTORY     ");
        System.out.println("╚════════════════════╝");
        System.out.println("1) Novo jogo");
        System.out.println("2) Continuar");
        System.out.println("3) Créditos");
        System.out.println("0) Sair");
        System.out.print("> ");
    }

    private int lerOpcao(){
        return sc.nextInt();
    }

    public void iniciar() throws InterruptedException {
        boolean rodando = true;

        while (rodando){
            mostrarMenu();

            int opcao = lerOpcao();

            switch (opcao){
                case 1:
                    novoJogo();
                    break;
                case 2:
                    continuar();
                    break;
                case 3:
                    creditos();
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    IO.println("Opção inválida, tente de novo.");
            }
        }
    }

    private void novoJogo() throws InterruptedException {

        sc.nextLine();

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("           NOVO JOGO");
        System.out.println("╚══════════════════════════════════════╝");

        IO.println("Digite o nome do seu pato: ");
        String nome = sc.nextLine();

        jogador = new Jogador(nome);
        maquinaPatinhos = new MaquinaPatinhos();

        IO.println("\n");
        deus.apresentar();
        Thread.sleep(5000);

        System.out.println("\n\n\n\n\n\n\n╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("???");
        System.out.println("  Muito bem, Pato " + jogador.getNome() + "!");
        System.out.println("  Sua missão é reconstruir a Vila Patotas.");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");

        Thread.sleep(5000);

        IO.println("\n\n\n\n\n\n\n");

        menuJogo();
    }

    private void menuJogo() throws InterruptedException {
        boolean jogando = true;

        while (jogando){

            verificarMaquinas();

            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("              DUCK FACTORY");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("    Dinheiro: "+ jogador.getSaldo());
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("  1) Máquinas");
            System.out.println("  2) Vila");
            System.out.println("  3) NPCs");
            System.out.println("  0) Voltar");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("> ");
            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    menuMaquinas();
                    break;

                case 2:
                    System.out.println();
                    System.out.println(" A vila ainda está em construção...");
                    break;

                case 3:
                    System.out.println();
                    System.out.println(" Ainda não existem NPCs disponíveis.");
                    break;

                case 0:
                    jogando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void menuMaquinas() throws InterruptedException {
        boolean aberto = true;

        while(aberto){

            verificarMaquinas();

            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("              MÁQUINAS");
            System.out.println("╠══════════════════════════════════════╣");

            System.out.println("1)  Máquina de Patinhos");

            if (maquinaPatinhos.isProduzindo()) {

                if (maquinaPatinhos.terminou()) {
                    System.out.println("   Status: PRONTA PARA COLETAR!");
                } else {
                    System.out.println("   Status: PRODUZINDO ("+maquinaPatinhos.tempoRestante()+" restantes)");
                }

            } else {
                System.out.println("   Status: PARADA");
            }

            System.out.println();
            System.out.println("2) Ativar máquina");
            System.out.println("3) Coletar produção");
            System.out.println("0) Voltar");

            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("> ");
            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    mostrarInformacoesMaquina();
                    break;

                case 2:
                    maquinaPatinhos.ativar();
                    break;

                case 3:
                    coletarMaquina();
                    break;

                case 0:
                    aberto = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void mostrarInformacoesMaquina() throws InterruptedException {

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("         MÁQUINA DE PATINHOS");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("  Nível: " + maquinaPatinhos.getNivel());
        System.out.println("  Produção: $" + maquinaPatinhos.getDinheiroPorCiclo());
        System.out.println("  Tempo: " + maquinaPatinhos.getTempoProducao() + " segundos");
        System.out.println("╚══════════════════════════════════════╝");

        Thread.sleep(5000);
    }

    private void coletarMaquina() {

        double dinheiro = maquinaPatinhos.coletar();

        if (dinheiro > 0) {
            jogador.adicionarDinheiro(dinheiro);

            System.out.printf(
                    " Você recebeu $%.2f!%n",
                    dinheiro
            );
        } else {
            System.out.println("A máquina ainda não terminou!");
        }
    }

    private void verificarMaquinas() {

        if (maquinaPatinhos != null &&
                maquinaPatinhos.isProduzindo() &&
                maquinaPatinhos.terminou()) {

            System.out.println();
            System.out.println("🔔 A Máquina de Patinhos terminou!");
        }
    }

    private void continuar() {

        System.out.println();
        System.out.println("💾 Sistema de save ainda não implementado.");
    }

    private void creditos() {

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("             DUCK FACTORY");
        System.out.println("             Feito por nick120q");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
