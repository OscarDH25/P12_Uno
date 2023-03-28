import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private boolean turno;
	private ArrayList<Carta> mano = new ArrayList<Carta>();

	public Jugador(String nombre, boolean turno, ArrayList<Carta> mano) {
		this.nombre = nombre;
		this.turno = turno;
		this.mano = mano;
	}

	public Jugador(String nombre, boolean turno) {
		this.nombre = nombre;
		this.turno = turno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
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
				aux += carta.getNumero() + " " + carta.getColor();
				break;
			case Chupate2, SaltarTurno, CambioSentido:
				aux += carta.getTipo() + " " + carta.getColor();
				break;
			default:
				aux += carta.getTipo();
				break;
			}
			aux += " | ";
		}
		return aux.substring(0, aux.length() - 2);
	}
}
