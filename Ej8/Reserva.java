package Ej8;

public class Reserva {

	private int id;
	private String dni;
	private int nroAsiento;
	
	public Reserva(int id, String dni, int nroAsiento) {
		this.id = id;
		this.dni = dni;
		this.nroAsiento = nroAsiento;
	}
	
	public int getNroAsiento() {
		return this.nroAsiento;
	}
	
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", dni=" + dni + ", nroAsiento=" + nroAsiento + "]";
	}
}
