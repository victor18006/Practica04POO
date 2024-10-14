public class Carta {
    private String palo; // Ejemplo: "oros", "copas", "espadas", "bastos"
    private String valor; // Ejemplo: "1", "2", "3", "rey", "as"

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}