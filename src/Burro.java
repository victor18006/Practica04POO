import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Burro {
    private List<Jugador> jugadores;
    private Baraja baraja;
    private Scanner scanner;

    public Burro(List<String> nombres) {
        jugadores = new ArrayList<>();
        for (String nombre : nombres) {
            jugadores.add(new Jugador(nombre));
        }
        baraja = new Baraja();
        baraja.mezclar();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        // Repartir cartas
        for (Jugador jugador : jugadores) {
            List<Carta> mano = baraja.repartir(4);
            for (Carta carta : mano) {
                jugador.agregarCarta(carta);
            }
        }

        // Comienza el juego
        boolean juegoActivo = true;
        while (juegoActivo) {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
                if (verificarGanador(jugador)) {
                    System.out.println(jugador.getNombre() + " ha ganado!");
                    juegoActivo = false;
                    break;
                }

                // Pedir carta a otro jugador
                pedirCarta(jugador);
            }
        }
    }

    private boolean verificarGanador(Jugador jugador) {
        // Verificar si el jugador tiene una combinación
        return jugador.tieneCombinacion("mismoPalo") || jugador.tieneCombinacion("mismoNumero");
    }

    private void pedirCarta(Jugador jugador) {
        System.out.println(jugador.getNombre() + ", elige a quién le quieres pedir una carta:");
        for (Jugador j : jugadores) {
            if (!j.equals(jugador)) {
                System.out.println(j.getNombre());
            }
        }

        String nombreOponente = scanner.nextLine();
        Jugador oponente = null;

        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombreOponente) && !j.equals(jugador)) {
                oponente = j;
                break;
            }
        }

        if (oponente != null && !oponente.getMano().getCartas().isEmpty()) {
            System.out.println("Elige un valor de carta que quieres pedir:");
            String valorPedido = scanner.nextLine();
            Carta cartaPedida = null;

            for (Carta carta : oponente.getMano().getCartas()) {
                if (carta.getValor().equalsIgnoreCase(valorPedido)) {
                    cartaPedida = carta;
                    break;
                }
            }

            if (cartaPedida != null) {
                oponente.quitarCarta(cartaPedida);
                jugador.agregarCarta(cartaPedida);
                System.out.println(jugador.getNombre() + " ha recibido " + cartaPedida);
            } else {
                System.out.println(oponente.getNombre() + " no tiene cartas de valor " + valorPedido);
            }
        } else {
            System.out.println("El jugador seleccionado no tiene cartas.");
        }
    }
}