package Ej5;

public class Test {

	public static void main(String[] args) {
		
		Empresa e = new Empresa();
		
		Camion ca1 = new Camion(100, 20);
		Camion ca2 = new Camion(101, 25);
		Chofer ch1 = new Chofer("200", "Marcelo", 2000);
		Chofer ch2 = new Chofer("201", "Raul", 1800);
		
		e.agregarCamiones(ca1);
		e.agregarCamiones(ca2);
		e.agregarChoferes(ch1);
		e.agregarChoferes(ch2);
		
		Viaje v1 = new Viaje(100, "200", 300);
		Viaje v2 = new Viaje(101, "201", 400);
		Viaje v3 = new Viaje(100, "201", 150);
		Viaje v4 = new Viaje(101, "201", 200);
		
		e.agregarViaje(v1);
		e.agregarViaje(v2);
		e.agregarViaje(v3);
		e.agregarViaje(v4);
		
		
		System.out.println(e);
		
		System.out.println("Costo promedio viajes: $" + e.obtenerCostosDeViajes());
		
		int[][] matriz = e.obtenerViajesXChoferCamion();
		
		for(int camion = 0; camion < matriz.length; camion++) {
			//System.out.println("Camion nro: " + (camion + 1) + " fue usado por: ");
			for(int chofer = 0; chofer < matriz[camion].length; chofer++) {
				//System.out.print(" Chofer nro: " + (chofer + 1) + ": ");
				System.out.print(matriz[camion][chofer]);
				//System.out.println(" veces");
			}
			System.out.println();
		}
		
	}

}
