package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglasJuegoComplica.
 */

public class ReglasJuegoComplica extends ReglasJuego {


	
	public ReglasJuegoComplica(){
		
	}


	/** The Constant COLUMNAS. */
	private static int COLUMNAS = 4;
	private static int FILAS=4;
	
	@Override
	public Tablero iniciaTablero() {

		
		Tablero tab = new Tablero(FILAS,COLUMNAS);
		return tab;
	}

	
	@Override
	public FICHA hayGanador(int f, int c, FICHA ultimo, Tablero tablero) {
		int n = 0;
		int fila = 0;
		int columna = 0;
		
		
		for( int i = 0; i < FILAS; i++){
			for (int col = 0; col < COLUMNAS; col++){
				if(ReglasJuegoCuatroEnLinea.cuatroEnLinea(tablero, i, col)){
					fila = i;
					columna = col;
					n++; 
				}
			}
		}
		

		if(n == ReglasJuegoCuatroEnLinea.CONECTA4) 
			return tablero.getFicha(fila, columna);
		else
			return FICHA.VACIA;
	}

	
	@Override
	public boolean tablas(Tablero t) {//Siempre devuelve falso
		return false;
	}


	@Override
	public FICHA jugadorInicial() {
		return FICHA.BLANCA;
	}


}
