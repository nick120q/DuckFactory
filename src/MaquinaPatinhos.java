public class MaquinaPatinhos extends Maquina {
    public MaquinaPatinhos() {
        super("Máquina de Patinhos", 10, 5);
    }

    @Override
    public double produzir() {
        return getDinheiroPorCiclo();
    }
}