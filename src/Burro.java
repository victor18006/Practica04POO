import java.util.*;

public class Burro {
    private Baraja baraja;
    private List<Jugador> jugadores;

    public Burro() {
        baraja = new Baraja();
        jugadores = new ArrayList<>();
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        int cantidadJugadores, vueltas = 0, usuario;
        boolean burroCompleto;
        System.out.println("\nBienvenido al juego ¡El burro!");
        System.out.println("Ingresa cantidad jugadores (4 - 10): ");
        do {
            cantidadJugadores = scanner.nextInt();
        } while (cantidadJugadores < 3 || cantidadJugadores > 10);
        preparaJugadores(cantidadJugadores);
        do {
            vueltas++;
            System.out.println("\t   Ronda " + vueltas);
            preparaBaraja();
            reparteBaraja();
            ronda();
            burroCompleto = encuentraGanador();
        } while (!burroCompleto/*&&cantidadJugadores>1*/);
    }

    public void preparaJugadores(int cantidad) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa el nombre del jugador " + (i + 1) + ": ");
            nombre = scanner.next();
            jugadores.add(new Jugador(nombre));
        }
    }

    public void preparaBaraja() {
        baraja.vaciarBaraja();
        baraja.creaBaraja(jugadores.size());
        baraja.mezclarBaraja();
    }

    public void reparteBaraja() {
        for (Jugador jugador : jugadores) {
            jugador.setMano(baraja.tomar4cartas());
        }
        System.out.println("...Repartiendo cartas...");
    }

    public boolean encuentraGanador() {
        boolean cadenaCompleta = false;
        int posPerdedor = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).burroEstaCompleto()) {
                cadenaCompleta = true;
                posPerdedor = i;
            } else {
                jugadores.get(i).getCantidadDeLetrasEnCadena();
            }
        }
        if (cadenaCompleta) {
            System.out.println("Juego terminado!");
            System.out.println(jugadores.get(posPerdedor).getNombre() + " es el burro! (jugador eliminado)");
        }
        return cadenaCompleta;
    }

    public void ronda() {
        Scanner scanner = new Scanner(System.in);
        int userAction, cantidadJugadores = jugadores.size();
        boolean cantoBurro = false;
        boolean[] jugadorCantor = new boolean[jugadores.size()];
        ArrayList<Carta> cartasDeIntercambio = new ArrayList<>();
        do {
            Arrays.fill(jugadorCantor, false);
            for (int i = 0; i < cantidadJugadores; i++) {
                System.out.println("Cartas de " + jugadores.get(i).getNombre() + ": ");
                jugadores.get(i).mostrarMano();
                System.out.println("Ingresa el número de carta a intercambiar o ingresa 0 para gritar ¡Burro!");
                do {
                    userAction = scanner.nextInt();
                } while (userAction < 0 || userAction > 4);
                if (userAction != 0) {
                    userAction -= 1;
                    cartasDeIntercambio.add(jugadores.get(i).entregaCarta(userAction));
                } else {
                    jugadorCantor[i] = true;
                }
            }
            for (boolean b : jugadorCantor) {
                if (b) {
                    cantoBurro = true;
                    break;
                }
            }
            if (!cantoBurro) {
                Collections.rotate(cartasDeIntercambio, -1);
                jugadores.forEach(jugador -> {
                    jugador.agregarCarta(cartasDeIntercambio.get(0));
                    cartasDeIntercambio.remove(0);
                });
            }
        } while (!cantoBurro);

        ArrayList<String> pilaDeManos = obtenerPilaDeManos(cantidadJugadores, jugadorCantor);
        int primerLugar = encuentraJugador(pilaDeManos.get(0));
        int ultimoLugar = encuentraJugador(pilaDeManos.get(pilaDeManos.size() - 1));
        System.out.println(pilaDeManos.get(0) + " gritó ¡Burro!");
        System.out.println(pilaDeManos);
        System.out.println("Su mano: ");
        jugadores.get(primerLugar).mostrarMano();
        if (jugadores.get(primerLugar).manoEsDelMismoValor()) {
            System.out.println("Perdedor: " + pilaDeManos.get(pilaDeManos.size() - 1));
            System.out.println("su cadena:\n" + jugadores.get(ultimoLugar).getBurro());
            jugadores.get(ultimoLugar).agregaLetraABurro();
            System.out.println("...Agregando letra...");
            System.out.println(jugadores.get(ultimoLugar).getBurro());
        } else {
            System.out.println(pilaDeManos.get(0) + " gritó ¡burro! sin tener la mano correcta");
            System.out.println("su cadena:\n" + jugadores.get(primerLugar).getBurro());
            jugadores.get(primerLugar).agregaLetraABurro();
            System.out.println("...Agregando letra...");
            System.out.println(jugadores.get(primerLugar).getBurro());
        }
    }

    private int encuentraJugador(String nombre) {
        int posicion = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(nombre)) {
                posicion = i;
            }
        }
        return posicion;
    }

    private ArrayList<String> obtenerPilaDeManos(int cantidadJugadores, boolean[] jugadorCantor) {
        ArrayList<String> posibleGanador = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadorCantor[i]) {
                posibleGanador.add(jugadores.get(i).getNombre());
            }
        }
        Collections.shuffle(posibleGanador);
        String primerLugar = posibleGanador.get(0);
        ArrayList<String> ordenDeManos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (!jugador.getNombre().equals(primerLugar)) {
                ordenDeManos.add(jugador.getNombre());
            }
        }
        Collections.shuffle(ordenDeManos);
        ordenDeManos.add(0, primerLugar);
        return ordenDeManos;
    }
}