package tp.pr4.jugadores;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class JugadorAleatorioGravity extends Jugador {

	@Override
	protected void obtenFilaColumna(Tablero tab, FICHA color) {
		boolean fin=false;
		int c=0;
		int f = 0;
		
		 while (!fin) {
			 c = (int)(tab.getAncho() * Math.random());
			 f = (int)(tab.getAlto() * Math.random());
			 if (tab.getFicha(f,c) == FICHA.VACIA)
				 fin = true;
		 }
		 
		 this.columna = c+1;
		 this.fila = f+1;

	}

}
