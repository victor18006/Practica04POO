import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = {"oros", "copas", "espadas", "bastos"};
        String[] valores = {"1", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey", "as"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(palo, valor));
            }
        }
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> repartir(int cantidad) {
        List<Carta> mano = new ArrayList<>();
        for (int i = 0; i < cantidad && !cartas.isEmpty(); i++) {
            mano.add(cartas.remove(0));
        }
        return mano;
    }
}