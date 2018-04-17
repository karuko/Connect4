package tp.pr4.movimiento;

import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.ColumnaLlena;
import tp.pr4.excepciones.FilaIncorrecta;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

// TODO: Auto-generated Javadoc
/**
 * The Class Movimiento.
 */
public abstract class Movimiento {

	/** The columna. */
	protected int columna;
	
	/** The turno. */
	protected FICHA turno;
	
	/** The fila. */
	protected int fila;
	
	
	
	/**
	 * Instantiates a new movimiento.
	 *
	 * @param columna the columna
	 * @param turno the turno
	 */
	Movimiento(int fila, int columna, FICHA turno) {
		this.fila = fila -1;
		this.columna = columna-1;
		this.turno = turno;
	}
	
	/**
	 * Gets the jugador.
	 *
	 * @return the jugador
	 */
	public FICHA getJugador() {
		return this.turno;
	}
	
	/**
	 * Gets the fila.
	 *
	 * @return the fila
	 */
	public int getFila(){
		return this.fila;

	}
	
	/**
	 * Gets the columna.
	 *
	 * @return the columna
	 */
	public int getColumna(){
		return this.columna;
	}

	/**
	 * Undo.
	 *
	 * @param t the t
	 */
	public abstract void undo(Tablero t);

	/**
	 * Ejecuta movimiento.
	 *
	 * @param t the t
	 * @return true, if successful
	 * @throws MovimientoInvalido 
	 * @throws ColumnaIncorrecta 
	 * @throws ColumnaLlena 
	 * @throws FilaIncorrecta 
	 */
	public abstract void ejecutaMovimiento(Tablero t) ;

	

}
