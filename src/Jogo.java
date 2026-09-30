import java.util.Scanner;

public class Jogo {
    PatoPresidente presidente = new PatoPresidente();
    PatoDeus deus = new PatoDeus();
    private Scanner sc = new Scanner(System.in);

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

    public void iniciar(){
        boolean rodando = true;

        while (rodando){
            mostrarMenu();
            int opcao = lerOpcao();

            switch (opcao){
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
                    rodando = false;
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente de novo.");
                    break;
            }
        }
    }

    private void novoJogo() {
        deus.apresentar();
    }

    private void continuar(){
        System.out.println("Ainda não implementado.");
    }

    private void creditos(){
        System.out.println("Feito por nick120q.");
    }
}
