package tp.pr4.jugadores;

import java.util.Scanner;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class JugadorHumanoReversi extends Jugador{

	private Scanner sc;
	public JugadorHumanoReversi(Scanner sc){
		
		this.sc = sc;
	}
	@Override
	protected void obtenFilaColumna(Tablero tab, FICHA color) {
		// TODO Auto-generated method stub
		
	}
}
