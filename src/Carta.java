import java.util.ArrayList;

public class Carta {
	private Tipo tipo;
	private Color color;
	private int numero;

	public Carta(Tipo tipo, Color color, int numero) {
		this.tipo = tipo;
		this.color = color;
		this.numero = numero;
	}

	public Carta(Tipo tipo) {
		this.tipo = tipo;
	}

	public Carta(Tipo tipo, Color color) {
		this.tipo = tipo;
		this.color = color;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static void crearCartas(ArrayList<Carta> mazoInicial) {
		for (Color color : Color.values()) {
			for (int i = 0; i <= 9; i += 2) {
				if (i == 0) {
					mazoInicial.add(new Carta(Tipo.Numero, color, i));
				} else {
					mazoInicial.add(new Carta(Tipo.Numero, color, i));
					mazoInicial.add(new Carta(Tipo.Numero, color, i));
				}
			}
			for (int i = 0; i < 2; i++) {
				mazoInicial.add(new Carta(Tipo.Chupate2, color));
				mazoInicial.add(new Carta(Tipo.CambioSentido, color));
				mazoInicial.add(new Carta(Tipo.SaltarTurno, color));
			}
		}
		for (int i = 0; i < 4; i++) {
			mazoInicial.add(new Carta(Tipo.CambiarColor));
			mazoInicial.add(new Carta(Tipo.Chupate4));
		}
	}

	public boolean isJugable(ArrayList<Carta> mazo, Carta carta) {
		Carta ultimaCarta = mazo.get(mazo.size() - 1);
		if (ultimaCarta.color == carta.color || ultimaCarta.numero == carta.numero
				|| carta.getTipo().equals(Tipo.CambiarColor) || carta.getTipo().equals(Tipo.Chupate4)) {
			return true;
		} else {
			return false;
		}
	}
}
