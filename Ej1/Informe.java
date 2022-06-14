package Ej1;

public class Informe {

	private double montoPedido;
	private String apellidoCajero;
	private int nivelBateriaRobot;
	
	public Informe(double montoPedido, String apellidoCajero, int nivelBateriaRobot) {
		this.montoPedido = montoPedido;
		this.apellidoCajero = apellidoCajero;
		this.nivelBateriaRobot = nivelBateriaRobot;
	}
	
	@Override
	public String toString() {
		return "Informe [montoPedido=" + montoPedido + ", apellidoCajero=" + apellidoCajero + ", nivelBateriaRobot="
				+ nivelBateriaRobot + "]";
	}
}
