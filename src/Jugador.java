import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private ArrayList<Carta> mano = new ArrayList<Carta>();

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}

	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}

	public String imprimirMano() {
		String aux = "";
		for (Carta carta : mano) {
			switch (carta.getTipo()) {
			case Numero:
				aux += mano.indexOf(carta) + 1 + ": " + carta.getNumero() + " " + carta.getColor();
				break;
			case Chupate2, SaltarTurno, CambioSentido:
				aux += mano.indexOf(carta) + 1 + ": " + carta.getTipo() + " " + carta.getColor();
				break;
			default:
				aux += mano.indexOf(carta) + 1 + ": " + carta.getTipo();
				break;
			}
			aux += " | ";
		}
		return aux.substring(0, aux.length() - 2);
	}
}
