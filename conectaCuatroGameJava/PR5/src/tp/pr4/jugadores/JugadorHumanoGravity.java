package tp.pr4.jugadores;

import java.util.Scanner;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class JugadorHumanoGravity extends Jugador{
	private Scanner sc;
	
	 public JugadorHumanoGravity(Scanner sc) { this.sc = sc;}
	 public void obtenFilaColumna(Tablero tab, FICHA color) {
		 
		 System.out.print("Introduce la fila: ");
		 int fila = sc.nextInt();
		 
		 System.out.print("Introduce la columna: ");
		 int col = sc.nextInt();
		 
		 sc.nextLine(); // Quitamos el INTRO
		 
	 this.fila = fila; 
	 this.columna=col;
	 }

}
