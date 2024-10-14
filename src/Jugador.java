public class Jugador {
    private String nombre;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Mano();
    }

    public String getNombre() {
        return nombre;
    }

    public Mano getMano() {
        return mano;
    }

    public void agregarCarta(Carta carta) {
        mano.agregarCarta(carta);
    }

    public void quitarCarta(Carta carta) {
        mano.quitarCarta(carta);
    }

    public boolean tieneCombinacion(String tipo) {
        return mano.tieneCombinacion(tipo);
    }

    @Override
    public String toString() {
        return nombre + ": " + mano.toString();
    }
}