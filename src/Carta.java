/**
 * Esta clase representa las cartas de la baraja Española
 */
public class Carta
{
    private int valor;
    private String palo;
    /**
     * Contructor no parametrizado dela clase Carta
     */
    public Carta() {
        this.valor = 0;
        this.palo = palo= "";
    }
    /**
     * Constructor parametrizado de la clase Carta
     * @param palo String que indica el palo de la carta
     * @param valor valor numerico que se le asignarâ a la carta
     */
    public Carta(String palo, int valor)
    {
        this.valor=valor;
        this.palo=palo;
    }
    /**
     * Constructor parametrizado del objeto de clase Carta
     * @param carta carta que recibe para crear una copia de ella
     */
    public Carta(Carta carta)
    {
        this.valor= carta.valor;
        this.palo= carta.palo;
    }
    /**
     * Getter de Palo
     * @return String palo
     */
    public String getPalo(){
        return palo;
    }
    /**
     * Getter de Valor
     * @return int valor
     */
    public int getValor(){
        return valor;
    }
    /**
     * Metodo ToSting de case Carta
     * @return String de carta
     */
    public String toString(){
        String cadena= new String();
        cadena= "["+valor;
        if (valor== 10) cadena+=" Sota";
        else if (valor== 11) cadena+=" Caballo";
        else if (valor== 12) cadena+=" Rey";
        cadena+=" "+palo+"]";
        return cadena;
    }
}