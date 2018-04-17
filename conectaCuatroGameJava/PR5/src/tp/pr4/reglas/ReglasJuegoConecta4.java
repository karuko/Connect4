package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;



// TODO: Auto-generated Javadoc
/**
 * The Class ReglasJuegoConecta4.
 */
public class ReglasJuegoConecta4 extends ReglasJuego {


	
	public ReglasJuegoConecta4(){
		
	}


	private static int COLUMNAS = 7;
	private static int FILAS=5;
	
	@Override
	public Tablero iniciaTablero() {
		
		
		Tablero tab = new Tablero(FILAS, COLUMNAS);
		tab.reset();
		return tab ;
	}

	
	@Override
	public FICHA hayGanador(int f, int c, FICHA ultimo, Tablero tablero) {
		if( ReglasJuegoCuatroEnLinea.cuatroEnLinea(tablero, f, c))
			return ultimo;
		else
			return FICHA.VACIA;
	}

	
	@Override
	public boolean tablas(Tablero t) {
		
		return t.completo();

	}


	@Override
	public FICHA jugadorInicial() {
		return FICHA.BLANCA;
	}

	
}
