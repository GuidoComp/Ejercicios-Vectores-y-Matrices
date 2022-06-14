package Ej5;

public class Chofer {

	private String id;
	private String nombre;
	private double pagoPorViaje;
	
	public Chofer(String id, String nombre, double pagoPorViaje) {
		this.id = id;
		this.nombre = nombre;
		this.pagoPorViaje = pagoPorViaje;
	}
	
	

	public String getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	@Override
	public String toString() {
		return "Chofer [id=" + id + ", nombre=" + nombre + ", pagoPorViaje=" + pagoPorViaje + "]";
	}

	public double getPagoPorViaje() {
		return this.pagoPorViaje;
	}
}
