package Ej7;

public class Alumno {

	
	private String apellido;
	
	public Alumno( String apellido) {
		this.apellido = apellido;
	}

	
	
	public String getApellido() {
		return apellido;
	}



	@Override
	public String toString() {
		return "Alumno [apellido=" + apellido + "]";
	}
	
	
}
