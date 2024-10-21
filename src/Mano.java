import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta entregaCarta(int pos) {
        return cartas.remove(pos);
    }

    public boolean esDelMismoValor() {
        return !cartas.isEmpty() && cartas.stream().allMatch(carta -> carta.getValor() == cartas.get(0).getValor());
    }

    public void mostrarMano() {
        cartas.forEach(System.out::println);
    }
}