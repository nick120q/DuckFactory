public class PatoPresidente extends Entidade {
    public PatoPresidente() {
        super("Carlos", "Presidente");
    }

    @Override
    public void apresentar() {
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("Presidente Carlos");
        System.out.println("  Olá, muitíssimo prazer!"+" Sou o Pato " + getNome() + ", o " + getFuncao() + ".");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
    }
}
