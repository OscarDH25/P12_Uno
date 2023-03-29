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

	@Override
	public String toString() {
		return "Carta [tipo=" + tipo + ", color=" + color + ", numero=" + numero + "]";
	}
}
