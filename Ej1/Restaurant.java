package Ej1;

import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {

	private static final int CANT_CAJEROS = 5;
	private static final int CANT_ROBOTS = 8;
	private ArrayList<Pedido> pedidos;
	private Cajero[] cajeros;
	private Robot[] robots;
	
	public Restaurant() {
		this.pedidos = new ArrayList<>();
		this.cajeros = new Cajero[CANT_CAJEROS];
		this.robots = new Robot[CANT_ROBOTS];
	}
	
	public double[] montosPorCajero() {
		double[] montosPorCajero = null;
		
		montosPorCajero = new double[CANT_CAJEROS];
		
		for (Pedido p: pedidos) {
			montosPorCajero[p.getIdCajero()] += p.getMonto();
		}
		return montosPorCajero;
	}
	
	public Informe[] informeDePedidos() {
		Informe[] informe = null;
		int index = 0;
		
		informe = new Informe[pedidos.size()];
		
		for (Pedido p: pedidos) {
			String apellidoCajero = null;
			Robot robot = null;
			
			apellidoCajero = this.cajeros[p.getIdCajero()].getApellido();
			robot = this.buscarRobot(p.getCodigoRobot());
			
			informe[index] = new Informe(p.getMonto(), apellidoCajero, robot.getNivelBateria());
			index++;
		}
		return informe;
	}
	
	public void mostrarPedidosConMasRiesgo() {
		for (Pedido p: pedidos) {
			Robot robotDespachador = null;
			
			robotDespachador = this.buscarRobot(p.getCodigoRobot());
			if (robotDespachador.bateriaEnNivelCritico()) {
				System.out.println(p);
			}
		}
	}
	
	private Robot buscarRobot(String codigoRobot) {
		Robot robotBuscado = null;
		Robot robotEncontrado = null;
		int index = 0;
		
		while (index < this.robots.length && robotBuscado == null) {
			robotEncontrado = this.robots[index];
			if (robotEncontrado.getCodigo().equals(codigoRobot)) {
				robotBuscado = robotEncontrado;
			} else {
				index++;
			}
		}
		return robotBuscado;
	}
	
	public void agregarCajero(Cajero c) {
		int index = 0;
		boolean cajeroAgregado = false;
		
		while (index < cajeros.length && !cajeroAgregado) {
			if (cajeros[index] == null) {
				cajeros[index] = c;
				cajeroAgregado = true;
			} else {
				index++;
			}
		}
	}
	
	public void agregarRobot(Robot r) {
		int index = 0;
		boolean robotAgregado = false;
		
		while (index < robots.length && !robotAgregado) {
			if (robots[index] == null) {
				robots[index] = r;
				robotAgregado = true;
			} else {
				index++;
			}
		}
	}
	
	public Pedido hacerPedido(String nombreCliente, int idCajero, String codigoRobot, double monto) {
		Pedido p = new Pedido(nombreCliente, idCajero, codigoRobot, monto);
		this.pedidos.add(p);
		return p;
	}

	@Override
	public String toString() {
		return "Restaurant [pedidos=" + pedidos + ", cajeros=" + Arrays.toString(cajeros) + ", robots="
				+ Arrays.toString(robots) + "]";
	}
}
