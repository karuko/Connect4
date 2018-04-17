package tp.pr4.jugadores;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class JugadorAleatorioConecta4 extends Jugador {

	protected void obtenFilaColumna(Tablero tab, FICHA color) {
		
		boolean fin=false;
		int columna=0;
		
		 while (!fin) {
			 columna = (int)(tab.getAncho() * Math.random());
			 if (tab.getFicha(0,columna) == FICHA.VACIA){
				
				 fin = true;
			 }
		 }
		 
		 this.columna = columna+1;

	}

}
