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

	public boolean isJugable(ArrayList<Carta> mazo, Carta carta) {
		Carta ultimaCarta = mazo.get(mazo.size() - 1);
		if (ultimaCarta.color == carta.color || ultimaCarta.numero == carta.numero
				|| carta.getTipo().equals(Tipo.CambiarColor) || carta.getTipo().equals(Tipo.Chupate4)) {
			return true;
		}
		else {
			return false;
		}
	}
}
