package Ej5;

import java.util.ArrayList;
import java.util.Arrays;

public class Empresa {

	public static final int CANT_CAMIONES = 2;
	public static final int CANT_CHOFERES = 2;
	private ArrayList<Viaje> viajes;
	private Camion[] camiones;
	private Chofer[] choferes;
	
	public Empresa() {
		this.viajes = new ArrayList<>();
		this.camiones = new Camion[CANT_CAMIONES];
		this.choferes = new Chofer[CANT_CHOFERES];
	}
	
	public double obtenerCostosDeViajes() {
		double sumaCostos = 0;
		Camion camion = null;
		Chofer chofer = null;
		
		for (Viaje v: this.viajes) {
			camion = buscarCamion(v.getIdCamion());
			sumaCostos += v.calcularConsumo(camion);
			chofer = buscarChofer(v.getIdChofer());
			sumaCostos += chofer.getPagoPorViaje();
		}
		
		return (double) sumaCostos / viajes.size();
	}
	
	public int[][] obtenerViajesXChoferCamion() {
		int[][] matrizViajes = null;
		int posicionCamion = 0;
		int posicionChofer = 0;
		
		matrizViajes = new int[camiones.length][choferes.length];
		
		for(Viaje v: this.viajes) {
			posicionCamion = getPosicionCamion(v.getIdCamion());
			posicionChofer = getPosicionChofer(v.getIdChofer());
			if (posicionCamion != Integer.MAX_VALUE && posicionChofer != Integer.MAX_VALUE) {
				matrizViajes[posicionCamion][posicionChofer]++;
			}
		}
		return matrizViajes;
	}
	
	private int getPosicionChofer(String idChofer) {
		int index = 0;
		boolean posicionEncontrada = false;
		Chofer choferEncontrado = null;
		int posicion = Integer.MAX_VALUE;
		
		while(index < choferes.length && !posicionEncontrada) {
			choferEncontrado = choferes[index];
			if (choferEncontrado.getId().equals(idChofer)) {
				posicionEncontrada = true;
				posicion = index;
			} else {
				index++;
			}
		}
		return posicion;
	}

	private int getPosicionCamion(int idCamion) {
		int index = 0;
		boolean posicionEncontrada = false;
		Camion camionEncontrado = null;
		int posicion = Integer.MAX_VALUE;
		
		while(index < camiones.length && !posicionEncontrada) {
			camionEncontrado = camiones[index];
			if (camionEncontrado.getId() == idCamion) {
				posicionEncontrada = true;
				posicion = index;
			} else {
				index++;
			}
		}
		return posicion;
	}

	private Chofer buscarChofer(String idChofer) {
		int index = 0;
		Chofer choferBuscado = null;
		Chofer choferEncontrado = null;
		
		while (index < choferes.length && choferBuscado == null) {
			choferEncontrado = choferes[index];
			if (choferEncontrado.getId() == idChofer) {
				choferBuscado = choferEncontrado;
			} else {
				index++;
			}
		}
		return choferBuscado;
	}

	private Camion buscarCamion(int idCamion) {
		int index = 0;
		Camion camionBuscado = null;
		Camion camionEncontrado = null;
		
		while (index < camiones.length && camionBuscado == null) {
			camionEncontrado = camiones[index];
			if (camionEncontrado.getId() == idCamion) {
				camionBuscado = camionEncontrado;
			} else {
				index++;
			}
		}
		return camionBuscado;
	}

	public void agregarCamiones(Camion c) {
		int index = 0;
		boolean camionAgregado = false;
		
		while(index < camiones.length && !camionAgregado) {
			if(camiones[index] == null) {
				camiones[index] = c;
				camionAgregado = true;
			} else {
				index++;
			}
		}
	}
	
	public void agregarChoferes(Chofer ch) {
		int index = 0;
		boolean choferAgregado = false;
		
		while(index < choferes.length && !choferAgregado) {
			if(choferes[index] == null) {
				choferes[index] = ch;
				choferAgregado = true;
			} else {
				index++;
			}
		}
	}
	
	public void agregarViaje(Viaje v) {
		this.viajes.add(v);
	}

	@Override
	public String toString() {
		return "Empresa [viajes=" + viajes + ", camiones=" + Arrays.toString(camiones) + ", choferes="
				+ Arrays.toString(choferes) + "]";
	}
}
