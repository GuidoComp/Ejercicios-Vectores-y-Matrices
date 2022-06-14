package Ej7;

import java.util.Arrays;

public class Comision {

	private static final char PRESENTE = 'P';
	private static final char TARDE = 'T';
	private static final char AUSENTE = 'A';
	private static final int CANT_CLASES = 4;
	private static final int ASIST_CONDICION_FINAL = 75;
	private static final double AUSENCIA_PARCIAL = 0.5;
	private static final int ABANDONO_CANT_AUS = 4;
	private String codigo;
	private int cantAlumnos;
	public char[][] asistenciaAlumnoClase;
	private Alumno[] alumnos;
	private Clase[] clases;
	
	public Comision(String codigo, int cantAlumnos) {
		this.codigo = codigo;
		this.cantAlumnos = cantAlumnos;
		this.alumnos = new Alumno[cantAlumnos];
		this.clases = new Clase[CANT_CLASES];
		this.asistenciaAlumnoClase = new char[cantAlumnos][CANT_CLASES];
	}
	
	private Alumno buscarAlumno(int posicion) {
		Alumno alumnoBuscado = null;
		if (posicion >= 0 && posicion < alumnos.length) {
			alumnoBuscado = alumnos[posicion];
		}
		return alumnoBuscado;
	}
	
	public void alumnosQueAbandonaron() {
		int cantAusencias = 0;
		int clase = 0;
		boolean abandono = false;
		
		for (int alumno = 0; alumno < asistenciaAlumnoClase.length; alumno++) { //recorrido de columnas en cada fila
			cantAusencias = 0;
			abandono = false;
			clase = 0;
			while (clase < asistenciaAlumnoClase[alumno].length && !abandono) { //por cada fila(alumno) pregunto si asistió a cada clase(columna)
				if (asistenciaAlumnoClase[alumno][clase] == AUSENTE) {
					cantAusencias++;
					if (cantAusencias >= ABANDONO_CANT_AUS) {
						abandono = true;
						System.out.println(buscarAlumno(alumno).getApellido());
					}
				}
				clase++;
			}
		}
	}
	
	public double[] presentismoPorClase() {
		double[] presentismoPorClase = null;
		int cantPresentes = 0;
		double porcentajePresentismo = 0;
		
		presentismoPorClase = new double[clases.length];
		
		for (int clase = 0; clase < clases.length; clase++) { //clase por clase calculo cantidad de asistencias de cada alumno (recorrido por columnas)
			porcentajePresentismo = 0;
			cantPresentes = 0;
			for (int alumno = 0; alumno < alumnos.length; alumno++) {
				if (asistenciaAlumnoClase[alumno][clase] != AUSENTE) {
					cantPresentes++;
				}
			}
			porcentajePresentismo = ((double) cantPresentes / alumnos.length) * 100;
			presentismoPorClase[clase] = porcentajePresentismo;
		}
		
		return presentismoPorClase;
	}
	
	public int cantClasesConAsistenciaPerfecta() { //recorrido de matriz por columnas
		boolean hayUnaFalta = false;
		int alumno = 0;
		int asistenciaPerfecta = 0;
		
		for (int clase = 0; clase < clases.length; clase++) {//recorre la cantidad de clases que tiene 1 alumno cualquiera
															 //también se podria poner: clase < asistenciaAlumnoClase[0].length
			alumno = 0;
			hayUnaFalta = false;
			while (alumno < asistenciaAlumnoClase.length && !hayUnaFalta) { // 
				if (asistenciaAlumnoClase[alumno][clase] == AUSENTE) {		// recorre para la misma clase, todos los alumnos
					hayUnaFalta = true;
				} else {
					alumno++;
				}
			}
			if (!hayUnaFalta) {
				asistenciaPerfecta++;
			}
		}
		return asistenciaPerfecta;
	}
	
	public int totalLlegadasTarde() { //recorrido de matriz por filas
		int llegadasTarde = 0;
		
		for (int alumno = 0; alumno < asistenciaAlumnoClase.length; alumno++) { //recorro filas (alumnos)
			for (int clase = 0; clase < asistenciaAlumnoClase[alumno].length; clase++) { //recorro columnas (clases). 1ero recorro cada clase de un alumno
				if (asistenciaAlumnoClase[alumno][clase] == TARDE) {
					llegadasTarde++;
				}
			}
		}
		return llegadasTarde;
	}
	
	public void mostrarAptosParaFinal() {
		double presentismo = 0;
		
		for(Alumno a: alumnos) {
			presentismo = calcularPresentismo(a); //Calculo el presentismo de cada alumno
			
			if (presentismo >= ASIST_CONDICION_FINAL) {
				System.out.println(a.getApellido() + " - " + presentismo + "%");
			}
		}
	}
	
	private double calcularPresentismo(Alumno a) {
		double cantTotalPresente = 0;
		int posicionAlumno = 0;
		
		posicionAlumno = posicionAlumno(a);
		
		for (int clase = 0; clase < clases.length; clase++) {
			
			switch (asistenciaAlumnoClase[posicionAlumno][clase]) { //Mismo alumno, presentismo en cada clase.
			case PRESENTE:
				cantTotalPresente++;
				break;
			case TARDE:
				cantTotalPresente += AUSENCIA_PARCIAL;
				break;
			}
		}
		return (cantTotalPresente / clases.length) * 100;
	}
	
	private int posicionAlumno(Alumno a) {
		int index = 0;
		int pos = Integer.MAX_VALUE;
		boolean posEncontrada = false;
		
		while (index < alumnos.length && !posEncontrada) {
			if (alumnos[index].getApellido().equals(a.getApellido())) {
				pos = index;
				posEncontrada = true;
			} else {
				index++;
			}
		}
		return pos;
	}
	
	public void setMatriz() {
		asistenciaAlumnoClase[0][0] = 'A';
		asistenciaAlumnoClase[0][1] = 'A';
		asistenciaAlumnoClase[0][2] = 'A';
		asistenciaAlumnoClase[0][3] = 'A';
		
		asistenciaAlumnoClase[1][0] = 'P';
		asistenciaAlumnoClase[1][1] = 'A';
		asistenciaAlumnoClase[1][2] = 'P';
		asistenciaAlumnoClase[1][3] = 'P';
		
		asistenciaAlumnoClase[2][0] = 'T';
		asistenciaAlumnoClase[2][1] = 'T';
		asistenciaAlumnoClase[2][2] = 'P';
		asistenciaAlumnoClase[2][3] = 'P';

		asistenciaAlumnoClase[3][0] = 'A';
		asistenciaAlumnoClase[3][1] = 'A';
		asistenciaAlumnoClase[3][2] = 'A';
		asistenciaAlumnoClase[3][3] = 'A';
	}
	
	public void agregarClase(Clase c) {
		int index = 0;
		boolean agregado = false;
		
		while (index < clases.length && !agregado) {
			if(clases[index] == null) {
				clases[index] = c;
				agregado = true;
			} else {
				index++;
			}
		}
	}
	
	public void agregarAlumno(Alumno a) {
		int index = 0;
		boolean agregado = false;
		while (index < alumnos.length && !agregado) {
			if(alumnos[index] == null) {
				alumnos[index] = a;
				agregado = true;
			} else {
				index++;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Comision [codigo=" + codigo + ", cantAlumnos=" + cantAlumnos + ", asistenciaAlumnoClase="
				+ Arrays.toString(asistenciaAlumnoClase) + ", alumnos=" + Arrays.toString(alumnos) + ", clases="
				+ Arrays.toString(clases) + "]";
	}
}
