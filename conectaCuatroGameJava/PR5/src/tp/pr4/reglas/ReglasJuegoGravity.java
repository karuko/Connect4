package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class ReglasJuegoGravity extends ReglasJuego {


	public ReglasJuegoGravity(int f, int c) {
	super(f, c);
	// TODO Auto-generated constructor stub
}
	public ReglasJuegoGravity(){
		
	}
	@Override
	public FICHA hayGanador(int f, int c, FICHA ultimo, Tablero tablero) {
		int n = 0;
		int fila = 0;
		int columna = 0;
		
		
		for( int i = 0; i < f; i++){
			for (int col = 0; col < c; col++){
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
	public boolean tablas(Tablero t) {
		
		return t.completo();
	}

	@Override
	public Tablero iniciaTablero() {
		
		Tablero tab = new Tablero(f, c);
		tab.reset();
		return tab ;
	}
	@Override
	public FICHA jugadorInicial() {
		return FICHA.BLANCA;
	}

}
