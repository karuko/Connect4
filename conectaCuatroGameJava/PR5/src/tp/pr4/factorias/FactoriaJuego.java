package tp.pr4.factorias;



import java.util.Scanner;

import tp.pr4.jugadores.Jugador;
import tp.pr4.logica.FICHA;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.reglas.ReglasJuego;

public interface FactoriaJuego {
	
	 public ReglasJuego creaReglas(int f, int c);
	 public Movimiento creaMovimiento(int fila, int col, FICHA color);
	 public Jugador creaJugadorAleatorio();
	 public Jugador creaJugadorHumano(Scanner sc);
	 
}
