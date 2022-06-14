package Ej5;

public class Viaje {

	private int idCamion;
	private String idChofer;
	private double kmsViaje;
	
	public Viaje(int idCamion, String idChofer, double kmsViaje) {
		this.idCamion = idCamion;
		this.idChofer = idChofer;
		this.kmsViaje = kmsViaje;
	}
	
	

	public String getIdChofer() {
		return idChofer;
	}



	public int getIdCamion() {
		return idCamion;
	}



	@Override
	public String toString() {
		return "Viaje [idCamion=" + idCamion + ", idChofer=" + idChofer + ", kmsViaje=" + kmsViaje + "]";
	}



	public double calcularConsumo(Camion camion) {
		return camion.getCostoPorKm() * this.kmsViaje;
	}
}
