package Ej8;

import java.util.ArrayList;

public class Aerolinea {

	private ArrayList<Reserva> reservas;
	private Avion avion;
	
	public Aerolinea(String nombre) {
		this.reservas = new ArrayList<>();
		this.avion = new Avion(nombre);
	}
	
	public int asientosLibresConVentanilla() {
		return avion.asientosLibresConVentanilla();
	}
	
	public void asignar() {
		int nroAsiento = 0;
		
		for(Reserva r: reservas) {
			nroAsiento = r.getNroAsiento();
			avion.reservarAsiento(nroAsiento);
		}
	}
	
	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	@Override
	public String toString() {
		return "Aerolinea [reservas=" + reservas + ", avion=" + avion + "]";
	}
}
