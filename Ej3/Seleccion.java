package Ej3;

import java.util.Arrays;

public class Seleccion {

	private static final int CANT_RESERVA = 5;
	private static final int CANT_JUGADORES = 23;
	private Jugador[] jugadores;
	
	public Seleccion() {
		this.jugadores = new Jugador[CANT_JUGADORES];
	}
	
	public int[] cantJugadoresPorPosicion() {
		int[] arrayPosiciones = null;
		
		arrayPosiciones = new int[Posicion.values().length];
		
		for (int i = 0; i < Posicion.values().length; i++) {
			arrayPosiciones[i] = this.cantJugadores(Posicion.values()[i]);
		}
		return arrayPosiciones;
	}
	
	private int cantJugadores(Posicion posicion) {
		
		int cantidad = 0;
		for (Jugador j: jugadores) {
			if (j.getPosicion().equals(posicion)) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public Jugador[] obtenerReservas() {
		Jugador[] jugadoresReserva = null;
		int indiceReserva = 0;
		int index = 0;
		
		jugadoresReserva = new Jugador[CANT_RESERVA];
		indiceReserva = CANT_JUGADORES - CANT_RESERVA;
		
		for (int i = indiceReserva; i < jugadores.length; i++) {
			jugadoresReserva[index] = jugadores[i];
			index++;
		}
		return jugadoresReserva;
	}
	
	private Jugador buscarJugadorPorApellido(String apellido) {
		Jugador jugadorEncontrado = null;
		Jugador jugadorBuscado = null;
		int index = 0;
		
		while (index < jugadores.length && jugadorBuscado == null) {
			jugadorEncontrado = jugadores[index];
			if (jugadorEncontrado.getApellido().equals(apellido)) {
				jugadorBuscado = jugadorEncontrado;
			} else {
				index++;
			}
		}
		return jugadorBuscado;
	}
	
	public void cambioPorLesion(int nroCamisetaLesionado, String apellidoReemplazante) {
		Jugador jugadorReemplazante = null;
		Jugador jugadorLesionado = null;
		
		jugadorLesionado = this.buscarJugadorPorCamiseta(nroCamisetaLesionado);
		jugadorReemplazante = this.buscarJugadorPorApellido(apellidoReemplazante);
		
		jugadorReemplazante.setPosicion(jugadorLesionado.getPosicion());
		
		this.cambio(nroCamisetaLesionado, jugadorReemplazante.getNroCamiseta());
	}
	
	public void cambio(int nroCamiseta1, int nroCamiseta2) {
		Jugador jugador1 = null;
		Jugador jugador2 = null;
		int indiceJugador1 = 0;
		int indiceJugador2 = 0;
		
		if (nroCamiseta1 != nroCamiseta2) {
			jugador1 = this.buscarJugadorPorCamiseta(nroCamiseta1);
			jugador2 = this.buscarJugadorPorCamiseta(nroCamiseta2);
			if (jugador1 != null && jugador2 != null) {
				indiceJugador1 = this.indiceJugador(nroCamiseta1);
				indiceJugador2 = this.indiceJugador(nroCamiseta2);
				jugadores[indiceJugador1] = jugador2;
				jugadores[indiceJugador2] = jugador1;
			}
		}
	}
	
	private int indiceJugador(int nroCamiseta) {
		int index = 0;
		boolean indiceEncontrado = false;
		int indiceJugador = 30;
		Jugador jugadorEncontrado = null;
		
		while (index < jugadores.length && !indiceEncontrado) {
			jugadorEncontrado = jugadores[index];
			if (jugadorEncontrado.getNroCamiseta() == nroCamiseta) {
				indiceJugador = index;
				indiceEncontrado = true;
			} else {
				index++;
			}
		}
		return indiceJugador;
	}

	private Jugador buscarJugadorPorCamiseta(int nroCamiseta) {
		int index = 0;
		Jugador jugadorBuscado = null;
		Jugador jugadorEncontrado = null;
		
		while (index < jugadores.length && jugadorBuscado == null) {
			jugadorEncontrado = jugadores[index];
			if (jugadorEncontrado.getNroCamiseta() == nroCamiseta) {
				jugadorBuscado = jugadorEncontrado;
			} else {
				index++;
			}
		}
		return jugadorBuscado;
	}

	public void agregarJugador(Jugador jugador) {
		int index = 0;
		boolean jugadorAgregado = false;
		while(index < jugadores.length && !jugadorAgregado) {
			if (jugadores[index] == null) {
				jugadores[index] = jugador;
				jugadorAgregado = true;
			} else {
				index++;
			}
		}
	}

	@Override
	public String toString() {
		return "Seleccion [jugadores=" + Arrays.toString(jugadores) + "]";
	}
	
	
}
