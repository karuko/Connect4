package tp.pr4.logica;

public interface TableroInmutable {
	
	int getFilas();
	int getColumnas();
	FICHA getCasilla(int fila, int col);
	String toString();
}
