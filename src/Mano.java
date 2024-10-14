import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void quitarCarta(Carta carta) {
        cartas.remove(carta);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public boolean tieneCombinacion(String tipo) {
        if (tipo.equals("mismoPalo")) {
            return tieneMismoPalo();
        } else if (tipo.equals("mismoNumero")) {
            return tieneMismoNumero();
        }
        return false;
    }

    private boolean tieneMismoPalo() {
        if (cartas.isEmpty()) return false;

        String palo = cartas.get(0).getPalo();
        for (Carta carta : cartas) {
            if (!carta.getPalo().equals(palo)) {
                return false;
            }
        }
        return true;
    }

    private boolean tieneMismoNumero() {
        if (cartas.isEmpty()) return false;

        String valor = cartas.get(0).getValor();
        for (Carta carta : cartas) {
            if (!carta.getValor().equals(valor)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return cartas.toString();
    }
}