package tp.pr4.jugadores;

import java.util.Scanner;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class JugadorHumanoConecta4 extends Jugador {

	private Scanner sc;
	public JugadorHumanoConecta4(Scanner sc) {
		this.sc = sc;
	}

	@Override
	protected void obtenFilaColumna(Tablero tab, FICHA color) {
		
		System.out.print("Introduce la columna: ");
		 int columna = sc.nextInt();

		 this.columna = columna;

	}

}
