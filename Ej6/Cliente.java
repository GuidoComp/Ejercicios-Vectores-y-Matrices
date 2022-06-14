package Ej6;

public class Cliente {

	private String razonSocial;
	private String cuit;
	private String telefono;
	private Pais pais;
	
	

	public Cliente(String razonSocial, String cuit, String telefono, Pais pais) {
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.telefono = telefono;
		this.pais = pais;
	}

	public String getCuit() {
		return cuit;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return "Cliente [razonSocial=" + razonSocial + ", cuit=" + cuit + ", telefono=" + telefono + ", pais=" + pais
				+ "]";
	}
	
	
}
