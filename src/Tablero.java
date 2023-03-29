import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tablero {

	private ArrayList<Carta> mazoRobar;
	private ArrayList<Carta> mazoJugadas;
	private ArrayList<Jugador> jugadores;
	private int sentido;

	public Tablero(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.mazoRobar = new ArrayList<Carta>();
		this.mazoJugadas = new ArrayList<Carta>();
		sentido = 1;
	}

	public ArrayList<Carta> getMazoRobar() {
		return mazoRobar;
	}

	public void setMazoRobar(ArrayList<Carta> mazoRobar) {
		this.mazoRobar = mazoRobar;
	}

	public ArrayList<Carta> getMazoJugadas() {
		return mazoJugadas;
	}

	public void setMazoJugadas(ArrayList<Carta> mazoJugadas) {
		this.mazoJugadas = mazoJugadas;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getSentido() {
		return sentido;
	}

	public void setSentido(int sentido) {
		this.sentido = sentido;
	}

	public void prepararPartida() {
		crearCartas();
		repartir();
	}

	private void crearCartas() {
		for (Color color : Color.values()) {
			for (int i = 0; i <= 9; i += 2) {
				if (i == 0) {
					mazoRobar.add(new Carta(Tipo.Numero, color, i));
				} else {
					mazoRobar.add(new Carta(Tipo.Numero, color, i));
					mazoRobar.add(new Carta(Tipo.Numero, color, i));
				}
			}
			for (int i = 0; i < 2; i++) {
				mazoRobar.add(new Carta(Tipo.Chupate2, color));
				mazoRobar.add(new Carta(Tipo.CambioSentido, color));
				mazoRobar.add(new Carta(Tipo.SaltarTurno, color));
			}
		}
		for (int i = 0; i < 4; i++) {
			mazoRobar.add(new Carta(Tipo.CambiarColor));
			mazoRobar.add(new Carta(Tipo.Chupate4));
		}
		Collections.shuffle(mazoRobar);
	}

	private void repartir() {
		for (int i = 0; i < 7; i++) {
			for (Jugador jugador : jugadores) {
				jugador.recibirCarta(mazoRobar.remove(0));
			}
		}
		mazoJugadas.add(mazoRobar.remove(0));
	}

	public boolean isJugable(Carta carta) {
		Carta ultimaCarta = ultimaCarta();
		switch (carta.getTipo()) {
		case Numero:
			if (ultimaCarta.getColor() == carta.getColor() || ultimaCarta.getNumero() == carta.getNumero()) {
				return true;
			} else {
				return false;
			}
		case Chupate2, SaltarTurno, CambioSentido:
			if (ultimaCarta.getColor() == carta.getColor()) {
				return true;
			} else {
				return false;
			}
		default:
			return true;
		}

	}

	public Carta ultimaCarta() {
		return mazoJugadas.get(mazoJugadas.size() - 1);
	}

	private void soltarCarta(Carta carta, Jugador jugador) {
		mazoJugadas.add(jugador.getMano().remove(jugador.getMano().indexOf(carta)));
	}

	public void robarCarta(Jugador jugador) {
		jugador.recibirCarta(mazoRobar.remove(0));
	}

	private void cambioSentido() {
		switch (sentido) {
		case 1:
			sentido = -1;
			break;
		case -1:
			sentido = 1;
		}
	}

	public void cambiarColor() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿A que color quieres cambiar?");
		Carta ultimaCarta = ultimaCarta();
		ultimaCarta.setColor();
	}

	private void chupate(int cartas, Jugador jugador) {
		int indJugadorActual = jugadores.indexOf(jugador);
		Jugador siguienteJugador = jugadores.get(indJugadorActual + 1);
		for (int i = 0; i < cartas; i++) {
			siguienteJugador.recibirCarta(mazoRobar.remove(0));
		}
	}

	public int saltarTurno() {
		switch (sentido) {
		case 1:
			return 1;
		case -1:
			return -1;
		default:
			return 0;
		}
	}

	public boolean jugarCarta(Carta carta, Jugador jugador) {
		if (isJugable(carta)) {
			switch (carta.getTipo()) {
			case Numero:
				soltarCarta(carta, jugador);
				break;
			case CambioSentido:
				soltarCarta(carta, jugador);
				cambioSentido();
				break;
			case SaltarTurno:
				soltarCarta(carta, jugador);
				saltarTurno();
				break;
			case Chupate2:
				soltarCarta(carta, jugador);
				chupate(2, jugador);
				break;
			case Chupate4:
				soltarCarta(carta, jugador);
				chupate(4, jugador);
				cambioColor();
				break;
			case CambiarColor:
				soltarCarta(carta, jugador);
				cambioColor();
				break;
			}
			return true;
		} else {
			return false;
		}
	}

	public void voltearMazo() {
		mazoRobar = mazoJugadas;
		Collections.shuffle(mazoRobar);
		mazoJugadas.add(mazoRobar.remove(0));
	}

}
