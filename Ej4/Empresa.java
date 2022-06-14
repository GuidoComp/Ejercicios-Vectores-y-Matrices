package Ej4;

import java.util.ArrayList;
import java.util.Arrays;

public class Empresa {

	private static final int CANT_ESTACIONES = NombreEstacion.values().length;
	private Estacion[] estaciones;
	private ArrayList<Reserva> listaReservas;
	
	public Empresa() {
		this.estaciones = new Estacion[CANT_ESTACIONES];
		this.listaReservas = new ArrayList<>();
	}
	
	public double recaudacionTotal() {
		double montoTotal = 0;
		
		for(Reserva res: listaReservas) {
			montoTotal += res.decimePrecio();
		}
		return montoTotal;
	}
	
	public int cantVecesRecorrida(Estacion estacion) {
		int cantidadTotalPersonas = 0;
		
		for(Reserva r: this.listaReservas) {
			int personasPorReserva = 0;
			personasPorReserva = r.getCantPersonas();
			
			cantidadTotalPersonas += (r.cantVecesRecorrida(estacion) * personasPorReserva);
		}
		
		return cantidadTotalPersonas;
	}
	
	public void agregarEstacion(Estacion e) {
		int index = 0;
		boolean estacionAgregada = false;
		
		while (index < estaciones.length && !estacionAgregada) {
			if (estaciones[index] == null) {
				estaciones[index] = e;
				estacionAgregada = true;
			} else {
				index++;
			}
		}
	}
	
	public void agregarReserva(Reserva r) {
		this.listaReservas.add(r);
	}

	@Override
	public String toString() {
		return "Empresa [estaciones=" + Arrays.toString(estaciones) + ", listaReservas=" + listaReservas + "]";
	}
}
