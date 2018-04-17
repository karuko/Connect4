package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;



// TODO: Auto-generated Javadoc
/**
 * The Class ReglasJuego.
 */
public abstract class ReglasJuego {
	
	
	public static int f;
	public static int c;
	
	public ReglasJuego(int fila, int col){
		f = fila;
		c = col;
		
	}
	public ReglasJuego(){}
	
	/**
	 * Jugador inicial.
	 *
	 * @return the ficha
	 */
	public abstract FICHA jugadorInicial();
		
		
	
	
	
	/**
	 * Siguiente turno.
	 *
	 * @param ultimo the ultimo
	 * @return the ficha
	 */
	public FICHA siguienteTurno(FICHA ultimo){
		
		if (ultimo == FICHA.BLANCA)
			ultimo = FICHA.NEGRA;
		else
			ultimo = FICHA.BLANCA;
		
		return ultimo;
	}
	
	/**
	 * Hay ganador.
	 *
	 * @param f the f
	 * @param c the c
	 * @param ultimo the ultimo
	 * @param tablero the tablero
	 * @return the ficha
	 */
	public abstract FICHA hayGanador(int f, int c, FICHA ultimo, Tablero tablero);
	
	/**
	 * Tablas.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	public abstract boolean tablas(Tablero t);
	
	/**
	 * Inicia tablero.
	 *
	 * @return the tablero
	 */
	public abstract Tablero iniciaTablero();
	

	
	
	/**
	 * Hay cuatro.
	 *
	 * @param f the f
	 * @param c the c
	 * @param ultimo the ultimo
	 * @param tablero the tablero
	 * @return true, if successful
	 */
	
}
