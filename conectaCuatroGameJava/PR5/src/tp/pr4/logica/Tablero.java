package tp.pr4.logica;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero.
 */
public class Tablero {

	/** The filas. */
	private int alto;

	/** The columnas. */
	private int ancho;

	/** The tablero. */
	private FICHA[][] tablero;

	/** The num turnos. */
	private int numTurnos = 0;

	/**
	 * Instantiates a new tablero.
	 * 
	 * @param nf
	 *            the nf
	 * @param nc
	 *            the nc
	 */
	public Tablero(int nf, int nc) {

		this.alto = nf;
		this.ancho = nc;
		tablero = new FICHA[nf][nc];

		this.reset();

	}

	/**
	 * Pon ficha.
	 * 
	 * @param f
	 *            the f
	 * @param c
	 *            the c
	 * @param ficha
	 *            the ficha
	 */
	public void ponFicha(int f, int c, FICHA ficha) {
		this.tablero[f][c] = ficha;
		this.numTurnos++;

		if (this.tablero[f][c] == FICHA.VACIA)
			this.numTurnos--;
	}

	/**
	 * Gets the ficha.
	 * 
	 * @param f
	 *            the f
	 * @param c
	 *            the c
	 * @return the ficha
	 */
	public FICHA getFicha(int f, int c) {
		return this.tablero[f][c];

	}

	// o con un atributo privado o solo controlando la última fila
	/**
	 * Completo. Indica que el tablero esta completo
	 * 
	 * @return true, if successful
	 */
	public boolean completo() {
		// Contador = maximo
		int maxCont = this.alto * this.ancho;

		if (this.numTurnos == maxCont)
			return true;
		else
			return false;

	}

	/**
	 * toString. Muestra el estado del tablero.
	 * 
	 */
	public String toString() {

		String sep = System.getProperty("line.separator");
		String text = sep + "|";
		int c = 0;

		for (int a = 0; a < this.alto; a++) {
			c = a+1;
			for (int b = 0; b < this.ancho; b++) {
				if (getFicha(a, b) == FICHA.BLANCA)
					text = text + " " + "O";
				else if (getFicha(a, b) == FICHA.NEGRA)
					text = text + " " + "X";
				else
					text = text + " " + " ";

			}
			text = text + " |"+ c + sep + "|";

		}
		for (int i = 0; i < this.ancho; i++)
			text = text + " "+"_";
		
		text = text + " |" + sep + " ";

		for (int j = 1; j <= this.ancho ; j++)
			text = text + " " + j;

		return text;

	}

	public void reset() {
		for (int a = 0; a < alto; a++) {
			for (int b = 0; b < ancho; b++)
				this.tablero[a][b] = FICHA.VACIA;
		}
		
	}

	public int getAncho() {
		// TODO Auto-generated method stub
		return this.ancho;
	}

	public int getAlto() {
		// TODO Auto-generated method stub
		return this.alto;
	}
	

}
