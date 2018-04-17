package tp.pr4.movimiento;

import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

// TODO: Auto-generated Javadoc
/**
 * The Class MovimientoComplica.
 */
public class MovimientoComplica extends Movimiento {

	
	/** The ficha eliminada. */
	private  FICHA fichaEliminada;
	
	/** The Fila. */
//	private int Fila = Partida.getFILAS(); 
	
	/**
	 *  The undo.
	 *
	 * @param columna the columna
	 * @param turno the turno
	 */
	
	public MovimientoComplica(int fila, int columna, FICHA turno) {
		
		super(fila,columna, turno);
		this.fichaEliminada = FICHA.VACIA;
	
	}

	
	public void undo(Tablero t) {
		
		int f = this.getFila();
		int c = this.getColumna();
		
		if(this.fichaEliminada == FICHA.VACIA)
			t.ponFicha(f, c, FICHA.VACIA);
		
		else{	
			
			for(int i = 0;i<t.getAlto()-1;i++)	
				t.ponFicha(i, c, t.getFicha(i+1, c));
				
			t.ponFicha(t.getAlto()-1, c, this.fichaEliminada);
		}
		
    }



	
	public void ejecutaMovimiento(Tablero t) throws ColumnaIncorrecta  {
		
		int f = 0;
		int c = this.getColumna();
		if(!this.columnaCorrecta(t)) throw new ColumnaIncorrecta(c);
		
			f = this.getF(t, f, c);
			
			if(t.getFicha(f, c) != FICHA.VACIA){
				this.eliminaUltima(t, c);
				
			}
							
			t.ponFicha(f, c, this.getJugador());
			
	}
	
	/**
	 * Gets the f.
	 *
	 * @param t the t
	 * @param f the f
	 * @param c the c
	 * @return the f
	 */
	private int getF(Tablero t, int f, int c){
		boolean encontrado = false;
		 f = t.getAlto() - 1;
			while (f > 0 && encontrado == false) {

				if (t.getFicha(f, c) != FICHA.VACIA)
					f--;

				else
					encontrado = true;
			}
			return this.fila = f;
		
	}
	
	/**
	 * Elimina ultima.
	 *
	 * @param t the t
	 * @param c the c
	 */
	private void eliminaUltima(Tablero t, int c){
		FICHA ficha;
		
		this.fichaEliminada = t.getFicha(t.getAlto()-1, c);
		
		for(int i =t.getAlto()- 1;i>0;i--){
			ficha = t.getFicha(i-1, c);
			t.ponFicha(i, c, ficha);
			
		}		
	}



	private boolean columnaCorrecta(Tablero t) {
		if(this.getColumna() < 0 || this.getColumna() >= t.getAncho())
			return false;
		else
			return true;
			
	}

}
