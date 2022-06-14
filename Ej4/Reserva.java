package Ej4;

public class Reserva {
	
	private Recorrido recorrido;
	private int codigo;
	private int cantPersonas;
	
	public Reserva(Recorrido recorrido, int codigo, int cantPersonas) {
		this.recorrido = recorrido;
		this.codigo = codigo;
		this.cantPersonas = cantPersonas;
	}
	
	public int getCantPersonas() {
		return cantPersonas;
	}
	
	public double decimePrecio() {
		return this.recorrido.calcularPrecio();
	}
	
	public int cantVecesRecorrida(Estacion estacion) {
		return this.recorrido.cantVecesRecorrida(estacion);
	}
	
	@Override
	public String toString() {
		return "Reserva [recorrido=" + recorrido + ", codigo=" + codigo + ", cantPersonas=" + cantPersonas + "]";
	}
}
