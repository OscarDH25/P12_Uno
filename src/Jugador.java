import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private boolean turno;
	private ArrayList<Carta> mano;
	
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
	
	public void recibirCarta() {
		
	}
}
