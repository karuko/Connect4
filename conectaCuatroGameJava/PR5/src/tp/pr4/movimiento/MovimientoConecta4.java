package tp.pr4.movimiento;


import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.ColumnaLlena;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

// TODO: Auto-generated Javadoc
/**
 * The Class MovimientoConecta4.
 */
public class MovimientoConecta4 extends Movimiento {
	

	/**
	 * Instantiates a new movimiento conecta4.
	 *
	 * @param columna the columna
	 * @param turno the turno
	 */
	public MovimientoConecta4(int fila, int columna, FICHA turno) {
		super(fila,columna, turno);
		// TODO Auto-generated constructor stub
	}

	
	public void undo(Tablero t) {
		
		int f = this.getFila();
		t.ponFicha(f, this.getColumna(), FICHA.VACIA);
		
	}

	
	public  void ejecutaMovimiento(Tablero t)  {
		
		int f = 0;
		int c = this.getColumna();
		if(!this.columnaCorrecta(t)) throw new ColumnaIncorrecta(c);
		else if(this.columnaLlena(t)) throw new ColumnaLlena(this.columna);
		
				
			
			f = this.getF(t, f, c);
			
			t.ponFicha(f, c, this.getJugador());


	}
	
	private boolean columnaLlena(Tablero t) {
		
		if(t.getFicha(0, this.getColumna()) != FICHA.VACIA)
			return true;
		else
			return false;
		
	}


	private boolean columnaCorrecta(Tablero t) {
		if(this.getColumna() < 0 || this.getColumna() >= t.getAncho() || t.completo())
			return false;
		else
			return true;
			
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

}


