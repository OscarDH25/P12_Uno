import java.util.ArrayList;
import java.util.Collections;

public class Tablero {

	private static ArrayList<Carta> mazoRobar;
	private static ArrayList<Carta> mazoJugadas;

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

	public static void crearCartas() {
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

}
