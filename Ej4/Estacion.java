package Ej4;

public class Estacion {

	private NombreEstacion nombre;

	public Estacion(NombreEstacion nombre) {
		this.nombre = nombre;
	}
	
	public NombreEstacion getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + "]";
	}
}
