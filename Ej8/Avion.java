package Ej8;

import java.util.Arrays;

public class Avion {

	private String marca;
	private Asiento[][] asientos;
	private static final int FILAS = 2;
	private static final int COLUMNAS = 6;
	private static int contador = 1;
	
	public Avion(String marca) {
		this.marca = marca;
		this.asientos = new Asiento[FILAS][COLUMNAS];
		for(int f = 0; f < asientos.length; f++) {
			for(int c = 0; c < asientos[f].length; c++) {
				asientos[f][c] = new Asiento(contador, Estado.LIBRE);
				contador++;
			}
		}
	}
	
	public Asiento[][] getAsientos() {
		return asientos;
	}
	
	public void reservarAsiento(int nroAsiento) {
		Asiento asiento = null;
		asiento = buscarAsiento(nroAsiento);
		asiento.setEstado(Estado.RESERVADO);
	}

	public Asiento buscarAsiento(int nroAsiento) {
		int fila = 0;
		Asiento asiento = null;
		int columna = 0;
		
		while (fila < asientos.length && asiento == null) {
			columna = 0;
			while (columna < asientos[fila].length && asiento == null) {
				if (asientos[fila][columna].getNumero() == nroAsiento) {
					asiento = asientos[fila][columna];
				}
				columna++;
			}
			fila++;
		}
		return asiento;
	}

	public int asientosLibresConVentanilla() {
		int asientosLibresConVentanilla = 0;
		
		for (int f = 0; f < asientos.length; f++) {
			for (int c = 0; c < asientos[f].length; c += asientos[f].length - 1) {
				if (asientos[f][c].getEstado().equals(Estado.LIBRE)) {
					asientosLibresConVentanilla++;
				}
			}
		}
		return asientosLibresConVentanilla;
	}
	
	@Override
	public String toString() {
		return "Avion [marca=" + marca + ", asientos=" + Arrays.toString(asientos) + "]";
	}
}
