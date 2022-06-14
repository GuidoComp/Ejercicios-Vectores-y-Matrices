package Ej1;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Restaurant r = new Restaurant();
		
		Cajero c1 = new Cajero(0, "Perez", 3);
		Cajero c2 = new Cajero(1, "Dominguez", 1);
		Cajero c3 = new Cajero(2, "Fernandez", 10);
		Cajero c4 = new Cajero(3, "Companc", 7);
		Cajero c5 = new Cajero(4, "Campagnollo", 2);
		
		Robot r1 = new Robot("2342", 100);
		Robot r2 = new Robot("5566", 80);
		Robot r3 = new Robot("8899", 75);
		Robot r4 = new Robot("1122", 70);
		Robot r5 = new Robot("2248", 60);
		Robot r6 = new Robot("3366", 20);
		Robot r7 = new Robot("2288", 30);
		Robot r8 = new Robot("8795", 90);
		
		r.agregarCajero(c1);
		r.agregarCajero(c2);
		r.agregarCajero(c3);
		r.agregarCajero(c4);
		r.agregarCajero(c5);
		
		r.agregarRobot(r1);
		r.agregarRobot(r2);
		r.agregarRobot(r3);
		r.agregarRobot(r4);
		r.agregarRobot(r5);
		r.agregarRobot(r6);
		r.agregarRobot(r7);
		r.agregarRobot(r8);
		
		System.out.println(r);
		
		r.hacerPedido("Manu", 0, "2342", 500);
		r.hacerPedido("Clara", 1, "5566", 1500);
		r.hacerPedido("Marcelo", 2, "8899", 200.50);
		r.hacerPedido("Eduardo", 3, "1122", 800.5);
		r.hacerPedido("Marisa", 4, "2248", 1200.5);
		r.hacerPedido("Claudio", 0, "3366", 400.5);
		r.hacerPedido("Raul", 1, "2288", 400.5);
		r.hacerPedido("Mariel", 2, "8795", 150.9);
		
		System.out.println(Arrays.toString(r.montosPorCajero()));
		System.out.println(Arrays.toString(r.informeDePedidos()));
		
		r.mostrarPedidosConMasRiesgo();
	}

}
