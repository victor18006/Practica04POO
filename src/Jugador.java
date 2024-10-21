import java.util.List;

public class Jugador {
    private String nombre;
    private String burro;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.burro = "";
        this.mano = new Mano();
    }

    public void setMano(List<Carta> cartas) {
        mano = new Mano();
        cartas.forEach(mano::agregarCarta);
    }

    public void mostrarMano() {
        mano.mostrarMano();
    }

    public void agregarCarta(Carta carta) {
        mano.agregarCarta(carta);
    }

    public Carta entregaCarta(int pos) {
        return mano.entregaCarta(pos);
    }

    public boolean manoEsDelMismoValor() {
        return mano.esDelMismoValor();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregaLetraABurro() {
        burro += "burro".charAt(burro.length());
    }

    public String getBurro() {
        return burro;
    }

    public boolean burroEstaCompleto() {
        return burro.equals("burro");
    }

    public int getCantidadDeLetrasEnCadena() {
        return burro.length();
    }
}