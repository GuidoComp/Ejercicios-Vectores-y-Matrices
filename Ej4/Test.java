package Ej4;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Empresa em = new Empresa();
		
		Estacion e1 = new Estacion(NombreEstacion.BUENOS_AIRES);//0
		Estacion e2 = new Estacion(NombreEstacion.LUJAN);//1
		Estacion e3 = new Estacion(NombreEstacion.MERCEDES);//2
		Estacion e4 = new Estacion(NombreEstacion.SUIPACHA);//3
		Estacion e5 = new Estacion(NombreEstacion.CHIVILCOY);//4
		Estacion e6 = new Estacion(NombreEstacion.ALBERTI);//5
		Estacion e7 = new Estacion(NombreEstacion.BRAGADO);//6
		
		em.agregarEstacion(e1);
		em.agregarEstacion(e2);
		em.agregarEstacion(e3);
		em.agregarEstacion(e4);
		em.agregarEstacion(e5);
		em.agregarEstacion(e6);
		em.agregarEstacion(e7);
		
		Recorrido rec1 = new Recorrido(e1, e7);//240
		Recorrido rec2 = new Recorrido(e4, e7);//150
		Recorrido rec3 = new Recorrido(e6, e4);
		
		/*System.out.println(rec1.calcularPrecio());
		System.out.println(rec2.calcularPrecio());
		System.out.println(rec3.calcularPrecio());*/
		
		Reserva res1 = new Reserva(rec1, 45, 2);
		Reserva res2 = new Reserva(rec2, 55, 4);
		Reserva res3 = new Reserva(rec3, 30, 1);
		
		em.agregarReserva(res1);
		em.agregarReserva(res2);
		em.agregarReserva(res3);
		
		//El precio por estacion por la cantidad de estaciones por las que pasó el tren en su recorrido (sin contar estacion
		//de partida y contando estación de llegada)
		System.out.println(em.recaudacionTotal());//390
		
		//Cantidad de personas del viaje por la cantidad de veces que el tren en su recorrido pasó por la estación (incluyendo
		//el caso de viajes cuyo origen o destino fueron en tal estación)
		System.out.println(em.cantVecesRecorrida(e1));//
		//resultado: 2
		System.out.println(em.cantVecesRecorrida(e2)); //LUJAN
		//resultado: 2
		System.out.println(em.cantVecesRecorrida(e3));
		//resultado: 2
		System.out.println(em.cantVecesRecorrida(e4));//SUIPACHA
		//resultado: 7
		System.out.println(em.cantVecesRecorrida(e5));//CHIVILCOY
		//resultado: 7
		System.out.println(em.cantVecesRecorrida(e6));//ALBERTI
		//resultado: 7
		System.out.println(em.cantVecesRecorrida(e7));//BRAGADO
		//resultado: 6
		
		
		
	}

}
