package Ej3;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		Jugador j1 = new Jugador("Gomez", 5, Posicion.DEFENSOR); //titulares
		Jugador j2 = new Jugador("Martinez", 15, Posicion.DELANTERO);
		Jugador j3 = new Jugador("Cacho", 23, Posicion.DEFENSOR);
		Jugador j4 = new Jugador("Perez", 14, Posicion.DELANTERO);
		Jugador j5 = new Jugador("Fernandez", 7, Posicion.ARQUERO);
		Jugador j6 = new Jugador("Braulio", 20, Posicion.DELANTERO);
		Jugador j7 = new Jugador("Mario", 3, Posicion.MEDIOCAMPISTA);
		Jugador j8 = new Jugador("apellido8", 4, Posicion.MEDIOCAMPISTA);
		Jugador j9 = new Jugador("Conte", 9, Posicion.MEDIOCAMPISTA);
		Jugador j10 = new Jugador("Tevez", 11, Posicion.MEDIOCAMPISTA);
		Jugador j11 = new Jugador("Samuel", 30, Posicion.DELANTERO);
		
		Jugador j12 = new Jugador("Messi", 27, Posicion.DELANTERO); //suplentes
		Jugador j13 = new Jugador("Rodriguez", 6, Posicion.DEFENSOR);
		Jugador j14 = new Jugador("Guardiola", 8, Posicion.DEFENSOR);
		Jugador j15 = new Jugador("Centurion", 1, Posicion.ARQUERO);
		Jugador j16 = new Jugador("Gallardo", 13, Posicion.DEFENSOR);
		Jugador j17 = new Jugador("Aimar", 26, Posicion.MEDIOCAMPISTA);
		Jugador j18 = new Jugador("Gimenez", 12, Posicion.MEDIOCAMPISTA);
		
		Jugador j19 = new Jugador("Mascherano", 2, Posicion.MEDIOCAMPISTA); //reserva
		Jugador j20 = new Jugador("Ayala", 19, Posicion.DELANTERO);
		Jugador j21 = new Jugador("Gago", 33, Posicion.DEFENSOR);
		Jugador j22 = new Jugador("Riquelme", 45, Posicion.DELANTERO);
		Jugador j23 = new Jugador("Anderson", 50, Posicion.DEFENSOR);
		

		Seleccion s = new Seleccion();
		
		s.agregarJugador(j1);
		s.agregarJugador(j2);
		s.agregarJugador(j3);
		s.agregarJugador(j4);
		s.agregarJugador(j5);
		s.agregarJugador(j6);
		s.agregarJugador(j7);
		s.agregarJugador(j8);
		s.agregarJugador(j9);
		s.agregarJugador(j10);
		s.agregarJugador(j11);
		s.agregarJugador(j12);
		s.agregarJugador(j13);
		s.agregarJugador(j14);
		s.agregarJugador(j15);
		s.agregarJugador(j16);
		s.agregarJugador(j17);
		s.agregarJugador(j18);
		s.agregarJugador(j19);
		s.agregarJugador(j20);
		s.agregarJugador(j21);
		s.agregarJugador(j22);
		s.agregarJugador(j23);
		
		System.out.println(s);
		s.cambio(5, 15);
		System.out.println(s);
		s.cambioPorLesion(23, "Arruabarrena");
		System.out.println(s);
		
		//PASAR UN ARRAY A STRING PARA PODER VERLO 
		String arrayReservas = Arrays.toString(s.obtenerReservas());
		System.out.println(arrayReservas);
		
		String arrayJugadoresPorPosicion = Arrays.toString(s.cantJugadoresPorPosicion());
		System.out.println(arrayJugadoresPorPosicion);
		
		//System.out.println(Posicion.valueOf("DELANTERO").ordinal());
	}

}
