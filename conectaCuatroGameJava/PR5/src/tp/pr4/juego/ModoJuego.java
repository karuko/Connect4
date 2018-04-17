package tp.pr4.juego;

import tp.pr4.logica.FICHA;

public interface ModoJuego {

	void comenzar(FICHA turno);
	void terminar();
	void deshacerPulsado();
	void tableroPulsado(int f, int c);

	
}
