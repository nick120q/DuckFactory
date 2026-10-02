import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    private List<Maquina> maquinas;

    public Fabrica() {
        maquinas = new ArrayList<>();
    }

    public void adicionarMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public Maquina getMaquina(int indice) {
        if (indice >= 0 && indice < maquinas.size()) {
            return maquinas.get(indice);
        }

        return null;
    }
}