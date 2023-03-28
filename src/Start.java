import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	private static ArrayList<Jugador> jugadores;

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		System.out.println("Bienvenidos!!!, vamos a jugar al UNO!");
		String nombre = "";
		while(!nombre.equals("0")) {
			System.out.println("Introduce el nombre del jugador | Introduce un 0 para no añadir mas jugadores");
			nombre = teclado.nextLine();
			if(!nombre.equals("0")) {
				jugadores.add(new Jugador(nombre, false));
			}
		}
		System.out.println("Genial! Vamos a repartir las cartas");
		Tablero tablero = new Tablero(jugadores);
		tablero.prepararPartida();
	}

}
