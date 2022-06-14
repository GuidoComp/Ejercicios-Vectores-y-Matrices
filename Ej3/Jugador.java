package Ej3;

public class Jugador {

	private String apellido;
	private int nroCamiseta;
	private Posicion posicion;
	
	public Jugador(String apellido, int nroCamiseta, Posicion posicion) {
		this.apellido = apellido;
		this.nroCamiseta = nroCamiseta;
		this.posicion = posicion;
	}
	
	public int getNroCamiseta() {
		return this.nroCamiseta;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setNroCamiseta(int nroCamiseta) {
		this.nroCamiseta = nroCamiseta;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador [apellido=" + apellido + ", nroCamiseta=" + nroCamiseta + ", posicion=" + posicion + "]";
	}
}
