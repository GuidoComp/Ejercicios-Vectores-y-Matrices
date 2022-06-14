package Ej7;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Comision c = new Comision("345345", 4);
		
		Alumno a1 = new Alumno("Alberti");
		Alumno a2 = new Alumno("Azcuenaga");
		Alumno a3 = new Alumno("Belgrano");
		Alumno a4 = new Alumno("Castelli");
		
		c.agregarAlumno(a1);
		c.agregarAlumno(a2);
		c.agregarAlumno(a3);
		c.agregarAlumno(a4);
		
		for (int i = 0; i < 4; i++) {
			c.agregarClase(new Clase(i));
		}
		
		System.out.println(c);
		
		c.setMatriz();
		
		System.out.println("");
		System.out.println("Aptos final:");
		c.mostrarAptosParaFinal();
		
		System.out.println("");
		System.out.println("Total llegadas tarde:");
		System.out.println(c.totalLlegadasTarde());
		
		System.out.println("");
		System.out.println("Clases con asistencia perfecta:");
		System.out.println(c.cantClasesConAsistenciaPerfecta());
		
		System.out.println("");
		System.out.println("Matriz:");
		for (int i = 0; i < c.asistenciaAlumnoClase.length; i++) {
			for (int j = 0; j < c.asistenciaAlumnoClase[i].length; j++) {
				System.out.print(c.asistenciaAlumnoClase[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
		System.out.println("Presentismo:");
		double[] arrayPresentismoPorClase = c.presentismoPorClase();
		String array = Arrays.toString(arrayPresentismoPorClase);
		System.out.println(array);
		
		System.out.println("");
		System.out.println("Abandonaron:");
		c.alumnosQueAbandonaron();
		
	}

}
