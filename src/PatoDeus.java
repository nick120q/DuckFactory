public class PatoDeus extends Entidade {
    public PatoDeus() {
        super("Eduardo", "Deus");
    }

    @Override
    public void apresentar() {
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("???");
        System.out.println("  Bom dia, meu filho."+" Eu sou o Pato " + getFuncao() + ", pode me chamar de " + getNome() + ".");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
    }
}
