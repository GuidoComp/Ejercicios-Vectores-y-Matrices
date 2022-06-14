package Ej8;

public class Test {

	public static void main(String[] args) {

		Aerolinea a = new Aerolinea("Aerolineas Argentinas");
		
		Asiento[][] matriz = a.getAvion().getAsientos();
		
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[f].length; c++) {
				System.out.print(matriz[f][c]);
			}
			System.out.println("");
		}
		
		Reserva r1 = new Reserva(100, "345", 1);
		Reserva r2 = new Reserva(101, "234", 2);
		Reserva r3 = new Reserva(102, "3546", 12);
		Reserva r4 = new Reserva(103, "456", 6);
		
		a.agregarReserva(r1);
		a.agregarReserva(r2);
		a.agregarReserva(r3);
		a.agregarReserva(r4);
		
		a.asignar();
		
		System.out.println("");
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[f].length; c++) {
				System.out.print(matriz[f][c]);
			}
			System.out.println("");
		}
		
		System.out.println("Cant asientos libres con ventanilla: " + a.asientosLibresConVentanilla());
		
	}

}
