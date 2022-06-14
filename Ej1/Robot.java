package Ej1;

public class Robot {

	private static final int NIVEL_CRITICO = 25;
	private String codigo;
	private int nivelBateria;
	
	public Robot(String codigo, int nivelBateria) {
		this.codigo = codigo;
		this.nivelBateria = nivelBateria;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getNivelBateria() {
		return nivelBateria;
	}
	
	public boolean bateriaEnNivelCritico() {
		return this.getNivelBateria() < NIVEL_CRITICO;
	}
	
	@Override
	public String toString() {
		return "Robot [codigo=" + codigo + ", nivelBateria=" + nivelBateria + "]";
	}
}
