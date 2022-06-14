package Ej8;

public class Asiento {

	private int numero;
	private Estado estado;
	
	public Asiento(int numero, Estado estado) {
		this.numero = numero;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Asiento [numero=" + numero + ", estado=" + estado + "]";
	}

	public void setEstado(Estado estado) {
		this.estado = estado;		
	}

	public int getNumero() {
		return this.numero;
	}

	public Estado getEstado() {
		return this.estado;
	}
}
