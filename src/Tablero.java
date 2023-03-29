import java.util.ArrayList;
import java.util.Collections;

public class Tablero {

	private ArrayList<Carta> mazoRobar;
	private ArrayList<Carta> mazoJugadas;
	private ArrayList<Jugador> jugadores;

	public Tablero(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.mazoRobar = new ArrayList<Carta>();
		this.mazoJugadas = new ArrayList<Carta>();
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
		Carta ultimaCarta = mazoJugadas.get(mazoJugadas.size() - 1);

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

	public String jugarCambiarColor(Jugador jugador, Color nuevoColor) {

		Carta ultimaCarta = ultimaCarta();

		if (ultimaCarta == null || ultimaCarta.getTipo() == Tipo.CambiarColor) {

			Carta cartaJugada = jugador.getMano().remove(0);
			cartaJugada.setColor(nuevoColor);
			mazoJugadas.add(cartaJugada);

		} else {
			return "no se puede jugar esa carta";
		}
		return null;

	}

}
