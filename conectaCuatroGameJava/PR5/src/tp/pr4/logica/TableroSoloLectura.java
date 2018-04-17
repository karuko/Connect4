package tp.pr4.logica;

public class TableroSoloLectura implements TableroInmutable{
	
	private Partida partida;
	
	public TableroSoloLectura(Partida partida) {
		this.partida = partida;
	}
	@Override
	public int getFilas() {
		
		return partida.getTablero().getAlto();
	}

	@Override
	public int getColumnas() {
		// TODO Auto-generated method stub
		return partida.getTablero().getAncho();
	}

	@Override
	public FICHA getCasilla(int fila, int col) {
		
		return partida.getTablero().getFicha(fila, col);
	}
	
}
