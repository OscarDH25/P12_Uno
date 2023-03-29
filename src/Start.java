import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	private static int pedirInt() {
		Scanner teclado = new Scanner(System.in);
		while (!teclado.hasNextInt()) {
			teclado.next();
			System.out.println("Valor no valido");
		}
		return teclado.nextInt();
	}


	private static boolean victoria() {
		boolean fin = false;
		for (Jugador jugador : jugadores) {
			if (jugador.getMano().isEmpty()) {
				fin = true;
			}
		}
		return fin;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Bienvenidos!!!, vamos a jugar al UNO!");
		String nombre = "";
		while (!nombre.equals("0")) {
			System.out.println("Introduce el nombre del jugador | Introduce un 0 para no añadir mas jugadores");
			nombre = teclado.nextLine();
			if (!nombre.equals("0")) {
				jugadores.add(new Jugador(nombre));
			}
		}
		System.out.println("Genial! Vamos a repartir las cartas");
		Tablero tablero = new Tablero(jugadores);
		tablero.prepararPartida();
		int jugadorActual = 0;
		while (!victoria()) {
			Jugador jugador = jugadores.get(jugadorActual);
			System.out.println(
					"\n" + jugador.getNombre() + " te toca! Elige la carta que quieres jugar o pulsa 0 para robar");
			System.out.println(jugador.imprimirMano());
			Carta ultimaCarta = tablero.ultimaCarta();
			System.out.println("Carta actual: " + ultimaCarta.imprimirCarta(tablero.ultimaCarta()));
			int cartaJugada = pedirInt();
			while (cartaJugada < 1 || cartaJugada > jugador.getMano().size()) {
				System.out.println("Valor invalido, vuelve a introducir que carta quieres jugar o 0 para robar");
				System.out.println(jugador.imprimirMano());
				cartaJugada = pedirInt();
			}
			if (cartaJugada == 0) {
				tablero.robarCarta(jugador);
			} else {
				if (tablero.jugarCarta(jugador.getMano().get(cartaJugada - 1), jugador)) {
					jugadorActual = (jugadorActual + tablero.getSentido()+ tablero.saltarTurno()) % jugadores.size();
				} else {
					System.out.println("No puedes jugar esa carta");
				}
			}
			if(jugador.unoCheck()) {
				System.out.println("UNO!!!!!");
			}
			if(tablero.getMazoRobar().isEmpty()) {
				tablero.voltearMazo();
			}
		}
		System.out.println("Fin de la partida");
	}
}
