package tp.pr4.movimiento;

import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;
import tp.pr4.reglas.ReglasJuegoReversi;

public class MovimientoReversi extends Movimiento{

	
	private Tablero taux;
	
	
	public MovimientoReversi(int fila, int columna, FICHA turno) {
		super(fila, columna, turno);
		
	}

	@Override
	public void undo(Tablero t) {
		
		//copia tablero.	
		
		for(int i = 0; i<taux.getAlto(); i++)
			for(int j=0; j<taux.getAncho(); j++)
				t.ponFicha(i, j, taux.getFicha(i, j));
	}

	@Override
	public void ejecutaMovimiento(Tablero t) {
		int f = this.getFila();
		int c = this.getColumna();
		
		if(t.getFicha(f, c) == FICHA.VACIA && ReglasJuegoReversi.realizarJugada(t, f, c, this.getJugador())) { //Fin de juego para todas las fichas.
			this.copiaTablero(t);
			t.ponFicha(f, c, this.getJugador());
			this.compruebaCol(t, f, c, this.getJugador());
			this.compruebaFilas(t, f, c, this.getJugador());
			this.compruebaDiagonalDer(t, f, c, this.getJugador());
			this.compruebaDiagonalIzq(t, f, c, this.getJugador());
			
			
		}
		else
			throw new MovimientoInvalido("Movimiento invalido");
		
		
	}

	/**
	 * Comprueba col.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	 private void compruebaCol(Tablero t, int f, int c, FICHA casilla) {

		int fIni = f + 1;
		if(ReglasJuegoReversi.flanqueaColAbajo(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && t.getFicha(fIni, c) != casilla && t.getFicha(fIni, c) != FICHA.VACIA 
				) {
			
			t.ponFicha(fIni, c, casilla);
			fIni++;
			
			}
		}
			

		fIni = f - 1;
		if(ReglasJuegoReversi.flanqueaColArriba(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && t.getFicha(fIni, c) != casilla && t.getFicha(fIni, c) != FICHA.VACIA
					) {
				
				t.ponFicha(fIni, c, casilla);
				fIni--;
			}
		}
		

	}

	/**
	 * Comprueba filas.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	 private void compruebaFilas(Tablero t, int f, int c, FICHA casilla) {

		
		int cIni = c + 1;
		
		if(ReglasJuegoReversi.flanqueaFilaDerecha(t, f, c, casilla)) {
			while (ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(f, cIni) != casilla && t.getFicha(f, cIni) != FICHA.VACIA) {
				t.ponFicha(f, cIni, casilla);
				cIni++;
			}
		}
		
		
		cIni = c - 1;
		
		if(ReglasJuegoReversi.flanqueaFilaIzq(t, f, c, casilla)) {
			while (ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(f, cIni) != casilla && t.getFicha(f,cIni) != FICHA.VACIA) {
				t.ponFicha(f, cIni, casilla);
				cIni--;
			}
		}

	}

	/**
	 * Comprueba diagonal der.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	 private void compruebaDiagonalDer(Tablero t, int f, int c, FICHA casilla) {

		int cIni = c + 1;
		int fIni = f + 1;
		if(ReglasJuegoReversi.flanquearDiagDerArriba(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla && t.getFicha(fIni, cIni) != FICHA.VACIA) {
				t.ponFicha(fIni, cIni, casilla);
				cIni++;
				fIni++;
			}
		}
		
		fIni = f - 1;
		cIni = c - 1;
		if(ReglasJuegoReversi.flanquearDiagIzqArriba(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla  && t.getFicha(fIni, cIni) != FICHA.VACIA) {
				t.ponFicha(fIni, cIni, casilla);
				cIni--;
				fIni--;
			}
		}

		
	}

	/**
	 * Comprueba diagonal izq.
	 * 
	 * @param f
	 * @param c
	 * @param casilla
	 * @return the int
	 */
	 private void compruebaDiagonalIzq(Tablero t, int f, int c, FICHA casilla) {

		int cIni = c + 1;
		int fIni = f - 1;
		if(ReglasJuegoReversi.flanquearDiagDerAbajo(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla  && t.getFicha(fIni, cIni) != FICHA.VACIA) {
				t.ponFicha(fIni, cIni, casilla);
				cIni++;
				fIni--;
			}
		}
		fIni = f + 1;
		cIni = c - 1;
		
		if(ReglasJuegoReversi.flanquearDiagIzqAbajo(t, f, c, casilla)) {
			while (ReglasJuegoReversi.filaValida(fIni,t) && ReglasJuegoReversi.columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla  && t.getFicha(fIni, cIni) != FICHA.VACIA) {
				t.ponFicha(fIni, cIni, casilla);
				cIni--;
				fIni++;
			}
		}

	}
	 
	
	private void copiaTablero(Tablero t){
		
		taux = new Tablero(t.getAlto(),t.getAncho());
		for(int i = 0; i<t.getAlto(); i++)
			for(int j=0; j<t.getAncho(); j++)
				taux.ponFicha(i, j, t.getFicha(i, j));
	}
	

}
