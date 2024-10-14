import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nombres = new ArrayList<>();

        System.out.println("Introduce los nombres de los jugadores (termina con 'fin'):");
        while (true) {
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;
            nombres.add(nombre);
        }

        Burro juego = new Burro(nombres);
        juego.iniciar();
    }
}