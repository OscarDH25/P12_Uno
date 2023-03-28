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

	private static Color colorSiguiente(Color color) {
		Color[] colores = Color.values();
		return colores[(color.ordinal() + 1) % colores.length];
	}

	private static Tipo tipoSiguiente(Tipo tipo) {
		Tipo[] tipos = Tipo.values();
		return tipos[(tipo.ordinal() + 1) % tipos.length];
	}

	public static void crearCartas(ArrayList<Carta> mazoInicial) {
		Color color = Color.Amarillo;
		Tipo tipo = Tipo.Numero;
		for (int i = 0; i < 4; i++) {
			colorSiguiente(color);
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					mazoInicial.add(new Carta(tipo, color, i));
				} else {
					mazoInicial.add(new Carta(tipo, color, i));
					mazoInicial.add(new Carta(tipo, color, i));
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			tipo = Tipo.CambiarColor;
			mazoInicial.add(new Carta(tipo));
			mazoInicial.add(new Carta(tipo));
			tipo = Tipo.Chupate4;
			mazoInicial.add(new Carta(tipo));
			mazoInicial.add(new Carta(tipo));

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
