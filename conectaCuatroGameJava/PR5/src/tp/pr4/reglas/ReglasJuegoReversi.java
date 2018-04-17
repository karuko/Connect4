package tp.pr4.reglas;

import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class ReglasJuegoReversi extends ReglasJuego {

	 public ReglasJuegoReversi() {
		
	}
	 
	private static int COLUMNAS = 8;
	private static int FILAS=8;
	@Override
	public FICHA hayGanador(int f, int c, FICHA ultimo, Tablero tablero) {
		
		//Fin de juego y contar fichas blancas vs negras.
		
		if(this.tablas(tablero) || !this.hayJugada(tablero, f, c, ultimo)) {
			return this.ganador(tablero);
		}
		else
			return FICHA.VACIA; 
		
	}

	@Override
	public boolean tablas(Tablero t) {
		return t.completo();
	}

	@Override
	public Tablero iniciaTablero() {
		
		Tablero tab = new Tablero(FILAS, COLUMNAS);
		tab.reset();
		this.init(tab);
		return tab ;
		
	}
	private void init(Tablero tab){
		
		tab.ponFicha(3, 3, FICHA.BLANCA);
		tab.ponFicha(3, 4, FICHA.NEGRA);
		tab.ponFicha(4, 3, FICHA.NEGRA);
		tab.ponFicha(4, 4, FICHA.BLANCA);
		
	}
	
	 private FICHA ganador(Tablero t) {
		int n = 0;
		int b = 0;
		FICHA casilla = FICHA.VACIA;
		
		for(int f = 0; f < t.getAlto();f++) 
			for(int c = 0; c < t.getAncho();c++) {
				if(t.getFicha(f, c) == FICHA.NEGRA) n++;
				else if(t.getFicha(f, c) == FICHA.BLANCA) b++;
			}
		
		if(n > b) casilla = FICHA.NEGRA;
		else if (b > n) casilla = FICHA.BLANCA;
		
		return casilla;
			
	}

	@Override
	public FICHA jugadorInicial() {
		return FICHA.NEGRA;
	}
	
	static public boolean flanqueaColAbajo(Tablero t, int f, int c, FICHA casilla) {
		int fIni = f +1;
		
		
		
		int n = 0;
		while (filaValida(fIni,t) && t.getFicha(fIni, c) != casilla && t.getFicha(fIni, c) != FICHA.VACIA ) {

			fIni++;
			if(t.getFicha(fIni-1, c) != casilla) n++;
		}
		
		
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, c) == casilla && n > 0)
			return true;
		else
			return false;
		
	}
	static public boolean flanqueaColArriba(Tablero t, int f, int c, FICHA casilla) {
		int fIni = f - 1;
	
		
		
		int n = 0;
		while (filaValida(fIni,t) && t.getFicha(fIni, c) != casilla  && t.getFicha(fIni, c) != FICHA.VACIA ) {

			fIni--;
			if(t.getFicha(fIni+1, c) != casilla) n++;
		}
		
		
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, c) == casilla && n > 0)
			return true;
		else
			return false;
	}
	static public boolean flanqueaFilaDerecha(Tablero t, int f, int c, FICHA casilla) {
		int cIni = c + 1;
		
		int n = 0;
		while (columnaValida(cIni,t) && t.getFicha(f, cIni) != casilla  && t.getFicha(f, cIni) != FICHA.VACIA) {
			
			cIni++;
			if(t.getFicha(f, cIni-1) != casilla) n++;
		}
		
		if(!columnaValida(cIni,t)) cIni = c;
		
		if(t.getFicha(f, cIni) == casilla && n > 0)
			return true;
		else
			return false;
	}
	static public boolean flanqueaFilaIzq(Tablero t, int f, int c, FICHA casilla) {
		
		int cIni = c - 1;

		int n = 0;
		while (columnaValida(cIni,t)  && t.getFicha(f, cIni) != casilla && t.getFicha(f, cIni) != FICHA.VACIA) {
			
			cIni--;	
			if(t.getFicha(f, cIni+1) != casilla) n++;
			
		}
		if(!columnaValida(cIni,t)) cIni = c;
		
		if(t.getFicha(f, cIni) == casilla && n > 0)
			return true;
		else
			return false;
	}
	static public boolean flanquearDiagDerArriba(Tablero t, int f, int c, FICHA casilla) {
		int cIni = c + 1;
		int fIni = f + 1;
		
		
		
		int n = 0;
		while (filaValida(fIni,t) && columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla && t.getFicha(fIni, cIni) != FICHA.VACIA) {
			
			cIni++;
			fIni++;
			if(t.getFicha(fIni-1, cIni-1) != casilla) n++;
		}
		if(!columnaValida(cIni,t)) cIni = c;
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, cIni) == casilla && n > 0) return true;
		else return false;
	}
	static public boolean flanquearDiagIzqArriba(Tablero t, int f, int c, FICHA casilla) {
		int fIni = f - 1;
		int cIni = c - 1;
		
	
		
		int n = 0;
		while (filaValida(fIni,t) && columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla && t.getFicha(fIni, cIni) != FICHA.VACIA) {
			
			cIni--;
			fIni--;
			if(t.getFicha(fIni+1, cIni+1) != casilla) n++;
		}
		if(!columnaValida(cIni,t)) cIni = c;
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, cIni) == casilla && n > 0) return true;
		else return false;
	}
	static public boolean flanquearDiagDerAbajo(Tablero t, int f, int c, FICHA casilla) {
		int cIni = c + 1;
		int fIni = f - 1;

		
		int n = 0;
		while (filaValida(fIni,t) && columnaValida(cIni,t) && t.getFicha(fIni, cIni) != casilla && t.getFicha(fIni, cIni) != FICHA.VACIA) {
			
			cIni++;
			fIni--;
			if(t.getFicha(fIni+1, cIni-1) != casilla) n++;
		}
		if(!columnaValida(cIni,t)) cIni = c;
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, cIni) == casilla && n > 0) return true;
		else return false;
	}
	static public boolean flanquearDiagIzqAbajo(Tablero t, int f, int c, FICHA casilla) {
		int fIni = f + 1;
		int cIni = c - 1;
		
	
		
		int n = 0;
		while (filaValida(fIni,t) && columnaValida(cIni,t)&& t.getFicha(fIni, cIni) != casilla &&  t.getFicha(fIni, cIni) != FICHA.VACIA) {
			
			cIni--;
			fIni++;
			if(t.getFicha(fIni-1, cIni+1) != casilla) n++;
		}
		if(!columnaValida(cIni,t)) cIni = c;
		if(!filaValida(fIni,t)) fIni = f;
		
		if(t.getFicha(fIni, cIni) == casilla && n > 0) return true;
		else return false;
	}
	static public boolean realizarJugada(Tablero t, int f, int c, FICHA casilla) {
		if(flanqueaColAbajo(t, f, c, casilla) || flanqueaColArriba(t, f, c, casilla) 
				|| flanqueaFilaDerecha(t, f, c, casilla) || flanqueaFilaIzq(t, f, c, casilla)
				|| flanquearDiagDerAbajo(t, f, c, casilla) || flanquearDiagDerArriba(t, f, c, casilla)
				|| flanquearDiagIzqAbajo(t, f, c, casilla) || flanquearDiagIzqArriba(t, f, c, casilla))
			return true;
		else
			return false;
	}
	
	 public static boolean filaValida(int f, Tablero tablero) {
		return 0 <= f && f < tablero.getAlto();
	}

	/**
	 * Columna valida.
	 * 
	 * @param c
	 * @return true, if successful
	 */
	 public static boolean columnaValida(int c,Tablero tablero) {
		return 0 <= c && c < tablero.getAncho();
	}
	
	 private boolean hayJugada(Tablero t, int f, int c, FICHA casilla) {
		 boolean enc = false;
		 int i = 0;
		 int j = 0;
		 while(i < t.getAlto() && !enc) {
			 while(j < t.getAncho() && !enc) {
				 if(t.getFicha(i, j) == FICHA.VACIA && realizarJugada(t, i, j, casilla))
					enc = true;
				 j++;
				 
			 }
			 j=0;
			 i++;
			 
		 }
		
		 return enc;
	 
	 }
}
