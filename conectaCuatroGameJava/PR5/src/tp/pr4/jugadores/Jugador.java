package tp.pr4.jugadores;

import java.util.InputMismatchException;

import tp.pr4.excepciones.DatosIncorrectos;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;
import tp.pr4.movimiento.Movimiento;

abstract public class Jugador {

	 protected int fila; 
	 protected int columna;
	 protected abstract void obtenFilaColumna(Tablero tab, FICHA color);
	 
	 public Movimiento getMovimiento(FactoriaJuego factoria,
	 Tablero tab, FICHA color) throws DatosIncorrectos {
		 
		 try { 
			this.obtenFilaColumna(tab,color);
		 return factoria.creaMovimiento(this.fila,this.columna,color);
		 }
		 catch (InputMismatchException e){
			 throw new DatosIncorrectos("Los datos introducidos no son numericos");
		 }
	 
	 }

}
