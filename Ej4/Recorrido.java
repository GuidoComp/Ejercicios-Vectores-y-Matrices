package Ej4;

public class Recorrido {

	private Estacion estacionPartida;
	private Estacion estacionDestino;
	private static final int PRECIO_ESTACION = 50;
	private static final double DESCUENTO = 0.2;

	public Recorrido(Estacion estacionPartida, Estacion estacionDestino) {
		this.estacionPartida = estacionPartida;
		this.estacionDestino = estacionDestino;
	}

	public double calcularPrecio() {
		int cantEstacionesRecorridas = 0;
		double precio = 0;

		cantEstacionesRecorridas = this.cantEstacionesRecorridas();
		precio = cantEstacionesRecorridas * PRECIO_ESTACION;

		return this.aplicarDescuento(precio);
	}

	private double aplicarDescuento(double precio) {
		double precioConDescuento = precio;
		if (tieneDescuento()) {
			precioConDescuento = precio - (precio * DESCUENTO);
		}
		return precioConDescuento;
	}

	private boolean tieneDescuento() {
		boolean tieneDescuento = false;

		if (estacionPartida.getNombre().ordinal() == 0
				&& estacionDestino.getNombre().ordinal() == NombreEstacion.values().length - 1) {
			tieneDescuento = true;
		} else if (estacionPartida.getNombre().ordinal() == NombreEstacion.values().length - 1
				&& estacionDestino.getNombre().ordinal() == 0) {
			tieneDescuento = true;
		}
		return tieneDescuento;
	}

	public int cantEstacionesRecorridas() {
		int cantEstaciones = 0;
		int indiceDeEstacionDestino = estacionDestino.getNombre().ordinal();
		int indiceDeEstacionDePartida = estacionPartida.getNombre().ordinal();

		if (indiceDeEstacionDestino > indiceDeEstacionDePartida) {
			cantEstaciones = indiceDeEstacionDestino - indiceDeEstacionDePartida;
		} else {
			cantEstaciones = indiceDeEstacionDePartida - indiceDeEstacionDestino;
		}
		return cantEstaciones;
	}

	public int cantVecesRecorrida(Estacion estacion) {
		int cantVecesRecorrida = 0;
		int indiceEstacionMayor = 0;
		int indiceEstacionMenor = 0;

		if (estacionPartida.getNombre().ordinal() > estacionDestino.getNombre().ordinal()) {
			indiceEstacionMayor = estacionPartida.getNombre().ordinal();
			indiceEstacionMenor = estacionDestino.getNombre().ordinal();
		} else {
			indiceEstacionMayor = estacionDestino.getNombre().ordinal();
			indiceEstacionMenor = estacionPartida.getNombre().ordinal();
		}

		for (int i = indiceEstacionMenor; i <= indiceEstacionMayor; i++) {
			if (estacion.getNombre().ordinal() == i) {
				cantVecesRecorrida++;
			}
		}
		return cantVecesRecorrida;
	}

	@Override
	public String toString() {
		return "Recorrido [estacionPartida=" + estacionPartida + ", estacionDestino=" + estacionDestino + "]";
	}
}
