package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;


public class ReglasJuegoCuatroEnLinea {
	
	public static final int CONECTA4 = 4;

	static public boolean cuatroEnLinea(Tablero t, int f, int c){
		
		
		FICHA casilla = t.getFicha(f, c);
		if(casilla != FICHA.VACIA){

			return (compruebaCol(t,f, c, casilla) >= CONECTA4
				||compruebaDiagonalDer(t,f, c, casilla) >=CONECTA4
				||compruebaDiagonalIzq(t,f, c, casilla) >= CONECTA4 ||
				compruebaFilas(t,f, c, casilla) >= CONECTA4);
		}
		else
			return false;
		
	}
	/**
	 * Fila valida.
	 * 
	 * @param f
	 * @return true, if successful
	 */
	static private boolean filaValida(int f, Tablero tablero) {
		return 0 <= f && f < tablero.getAlto();
	}

	/**
	 * Columna valida.
	 * 
	 * @param c
	 * @return true, if successful
	 */
	static private boolean columnaValida(int c,Tablero tablero) {
		return 0 <= c && c < tablero.getAncho();
	}
	


	/**
	 * Comprueba col.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	static private int compruebaCol(Tablero t, int f, int c, FICHA casilla) {

		int fIni = f + 1;
		int enLinea = 1;
		while (filaValida(fIni,t) && t.getFicha(fIni, c) == casilla) {
			enLinea++;
			fIni++;
		}

		fIni = f - 1;
		while (filaValida(fIni,t) && t.getFicha(fIni, c) == casilla) {
			enLinea++;
			fIni--;
		}
		return enLinea;

	}

	/**
	 * Comprueba filas.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	static private int compruebaFilas(Tablero t, int f, int c, FICHA casilla) {

		
		int cIni = c + 1;
		int enLinea = 1;
		while (columnaValida(cIni,t) && t.getFicha(f, cIni) == casilla) {
			enLinea++;
			cIni++;
		}

		cIni = c - 1;
		while (columnaValida(cIni,t) && t.getFicha(f, cIni) == casilla) {
			enLinea++;
			cIni--;
		}

		return enLinea;

	}

	/**
	 * Comprueba diagonal der.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	static private int compruebaDiagonalDer(Tablero t, int f, int c, FICHA casilla) {

		int cIni = c + 1;
		int fIni = f + 1;
		int enLinea = 1;
		while (filaValida(fIni,t) && columnaValida(cIni,t)
				&& t.getFicha(fIni, cIni) == casilla) {
			enLinea++;
			cIni++;
			fIni++;
		}
		fIni = f - 1;
		cIni = c - 1;
		while (filaValida(fIni,t) && columnaValida(cIni,t)
				&& t.getFicha(fIni, cIni) == casilla) {
			enLinea++;
			cIni--;
			fIni--;
		}

		return enLinea;
	}

	/**
	 * Comprueba diagonal izq.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	static private int compruebaDiagonalIzq(Tablero t, int f, int c, FICHA casilla) {

		int cIni = c + 1;
		int fIni = f - 1;
		int enLinea = 1;
		while (filaValida(fIni,t) && columnaValida(cIni,t)
				&& t.getFicha(fIni, cIni) == casilla) {
			enLinea++;
			cIni++;
			fIni--;
		}
		fIni = f + 1;
		cIni = c - 1;
		while (filaValida(fIni,t) && columnaValida(cIni,t)
				&& t.getFicha(fIni, cIni) == casilla) {
			enLinea++;
			cIni--;
			fIni++;
		}

		return enLinea;

	}


}
