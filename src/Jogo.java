import java.util.Scanner;

public class Jogo {

    private final PatoPresidente presidente = new PatoPresidente();
    private final PatoDeus deus = new PatoDeus();

    private final Scanner sc = new Scanner(System.in);

    private Jogador jogador;
    private Fabrica fabrica;
    private MaquinaPatinhos maquinaPatinhos;

    private boolean jogoRodando;

    private void mostrarMenuPrincipal() {

        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("         DUCK FACTORY");
        System.out.println("╚══════════════════════════════╝");

        if (jogador != null) {
            System.out.println("Jogador: " + jogador.getNome());
            System.out.printf("Dinheiro: $%.2f%n", jogador.getSaldo());
            System.out.println();
        }

        System.out.println("1) Máquinas");
        System.out.println("2) Vila");
        System.out.println("3) NPCs");
        System.out.println("0) Sair");
        System.out.print("> ");
    }

    private int lerOpcao() {
        while (!sc.hasNextInt()) {
            System.out.println("Digite uma opção válida.");
            sc.next();
            System.out.print("> ");
        }

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }

    public void iniciar() {

        boolean rodando = true;

        while (rodando) {

            mostrarMenuInicial();

            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    novoJogo();
                    rodando = false;
                    break;

                case 2:
                    continuar();
                    rodando = false;
                    break;

                case 3:
                    creditos();
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void mostrarMenuInicial() {

        System.out.println();
        System.out.println("╔════════════════════╗");
        System.out.println("     DUCK FACTORY");
        System.out.println("╚════════════════════╝");
        System.out.println("1) Novo jogo");
        System.out.println("2) Continuar");
        System.out.println("3) Créditos");
        System.out.println("0) Sair");
        System.out.print("> ");
    }

    private void novoJogo() {

        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("          NOVO JOGO");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("Digite o nome do seu pato: ");
        String nome = sc.nextLine();

        jogador = new Jogador(nome);

        fabrica = new Fabrica();

        maquinaPatinhos = new MaquinaPatinhos();

        fabrica.adicionarMaquina(maquinaPatinhos);

        System.out.println();

        deus.apresentar();

        System.out.println();
        System.out.println("Sua missão é reconstruir a Vila Patotas.");
        System.out.println();

        jogo();
    }

    private void jogo() {

        jogoRodando = true;

        while (jogoRodando) {

            verificarMaquinas();

            mostrarMenuPrincipal();

            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    menuMaquinas();
                    break;

                case 2:
                    menuVila();
                    break;

                case 3:
                    menuNPCs();
                    break;

                case 0:
                    jogoRodando = false;
                    System.out.println("Saindo do jogo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void menuMaquinas() {

        boolean voltando = false;

        while (!voltando) {

            verificarMaquinas();

            System.out.println();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("           MÁQUINAS");
            System.out.println("╚══════════════════════════════╝");

            System.out.printf("Dinheiro: $%.2f%n", jogador.getSaldo());
            System.out.println();

            System.out.println("1) Máquina de Patinhos");
            System.out.println("0) Voltar");
            System.out.print("> ");

            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    menuMaquinaPatinhos();
                    break;

                case 0:
                    voltando = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void menuMaquinaPatinhos() {

        boolean voltando = false;

        while (!voltando) {

            verificarMaquinas();

            System.out.println();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("      MÁQUINA DE PATINHOS");
            System.out.println("╚══════════════════════════════╝");

            System.out.println();

            System.out.println("Nível: " + maquinaPatinhos.getNivel());

            System.out.printf(
                    "Produção: $%.2f por ciclo%n",
                    maquinaPatinhos.getDinheiroPorCiclo()
            );

            System.out.printf(
                    "Tempo: %.2f segundos%n",
                    maquinaPatinhos.getTempoProducao()
            );

            System.out.printf(
                    "Upgrade: $%.2f%n",
                    maquinaPatinhos.getCustoUpgrade()
            );

            System.out.println();

            if (maquinaPatinhos.isProduzindo()) {

                if (maquinaPatinhos.terminou()) {
                    System.out.println("Status: PRONTA PARA COLETAR");
                } else {
                    System.out.printf(
                            "Status: PRODUZINDO (%.1fs restantes)%n",
                            maquinaPatinhos.tempoRestante()
                    );
                }

            } else {
                System.out.println("Status: PARADA");
            }

            System.out.println();
            System.out.println("1) Ativar");
            System.out.println("2) Coletar");
            System.out.println("3) Melhorar");
            System.out.println("0) Voltar");
            System.out.print("> ");

            int opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    maquinaPatinhos.ativar();
                    break;

                case 2:
                    coletarMaquinaPatinhos();
                    break;

                case 3:
                    melhorarMaquinaPatinhos();
                    break;

                case 0:
                    voltando = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void coletarMaquinaPatinhos() {

        double valor = maquinaPatinhos.coletar();

        if (valor > 0) {

            jogador.adicionarDinheiro(valor);

            System.out.printf(
                    "Produção coletada! +$%.2f%n",
                    valor
            );

        } else {

            if (maquinaPatinhos.isProduzindo()) {
                System.out.printf(
                        "A produção ainda não terminou. %.1fs restantes.%n",
                        maquinaPatinhos.tempoRestante()
                );
            } else {
                System.out.println("A máquina não está produzindo.");
            }
        }
    }

    private void melhorarMaquinaPatinhos() {

        double custo = maquinaPatinhos.getCustoUpgrade();

        if (jogador.getSaldo() < custo) {

            System.out.printf(
                    "Dinheiro insuficiente. Você precisa de $%.2f.%n",
                    custo
            );

            return;
        }

        boolean melhorou = maquinaPatinhos.melhorar(jogador);

        if (melhorou) {
            System.out.println(
                    "Máquina melhorada para o nível "
                            + maquinaPatinhos.getNivel() + "!"
            );
        }
    }

    private void verificarMaquinas() {

        // Por enquanto não precisamos mostrar nada aqui.
        // A máquina é consultada quando o jogador abre o menu.
    }

    private void menuVila() {

        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("             VILA");
        System.out.println("╚══════════════════════════════╝");

        System.out.println();
        System.out.println("A Vila Patotas ainda está destruída.");
        System.out.println("Você precisará reconstruí-la.");
        System.out.println();
        System.out.println("Pressione ENTER para voltar.");

        sc.nextLine();
    }

    private void menuNPCs() {

        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("             NPCs");
        System.out.println("╚══════════════════════════════╝");

        System.out.println();
        presidente.apresentar();

        System.out.println();
        System.out.println("Pressione ENTER para voltar.");

        sc.nextLine();
    }

    private void continuar() {

        System.out.println();
        System.out.println("O sistema de save ainda não foi implementado.");
        System.out.println();
    }

    private void creditos() {

        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("            CRÉDITOS");
        System.out.println("╚══════════════════════════════╝");

        System.out.println();
        System.out.println("Duck Factory");
        System.out.println("Desenvolvido por nick120q");
        System.out.println();
    }
}