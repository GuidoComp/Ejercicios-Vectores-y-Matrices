package Ej6;

public class Vendedor {

	private int id;
	private String nombre;
	
	public Vendedor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	

	public int getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + "]";
	}
}
