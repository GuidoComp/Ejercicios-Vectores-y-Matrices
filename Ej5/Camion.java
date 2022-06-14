package Ej5;

public class Camion {

	private int id;
	private double costoPorKm;
	
	public Camion(int id, double costoPorKm) {
		this.id = id;
		this.costoPorKm = costoPorKm;
	}
	
	

	public int getId() {
		return id;
	}



	public double getCostoPorKm() {
		return costoPorKm;
	}



	@Override
	public String toString() {
		return "Camion [id=" + id + ", costoPorKm=" + costoPorKm + "]";
	}
}
