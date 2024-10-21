import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Baraja {
    private List<Carta> baraja;
    private String[] palo;
    private int numeroJugadores;

    public Baraja() {
        baraja = new ArrayList<>();
        palo = new String[]{"Oros", "Copas", "Espadas", "Bastos"};
    }

    public void creaBaraja(int numeroJugadores) {
        for (String p : palo) {
            IntStream.rangeClosed(1, numeroJugadores).forEach(j -> baraja.add(new Carta(p, j)));
        }
    }

    public void vaciarBaraja() {
        baraja.clear();
    }

    public void mezclarBaraja() {
        Collections.shuffle(baraja);
    }

    public Carta entregaCarta() {
        return baraja.remove(0);
    }

    public List<Carta> tomar4cartas() {
        List<Carta> mano = new ArrayList<>();
        IntStream.range(0, 4).forEach(i -> mano.add(entregaCarta()));
        return mano;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }
}