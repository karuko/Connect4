package tp.pr4.factorias;

import java.util.Scanner;

import tp.pr4.jugadores.Jugador;
import tp.pr4.jugadores.JugadorAleatorioConecta4;
import tp.pr4.jugadores.JugadorHumanoConecta4;
import tp.pr4.logica.FICHA;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.movimiento.MovimientoConecta4;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoConecta4;

public class FactoriaJuegoConecta4 implements FactoriaJuego {
	
	 public Jugador creaJugadorAleatorio() {
		 	return new JugadorAleatorioConecta4();
		 }
	 
		 public Jugador creaJugadorHumano(Scanner sc) {
			 return new JugadorHumanoConecta4(sc);
		 }
		 
		 public Movimiento creaMovimiento(int f, int c, FICHA color) {
			 return new MovimientoConecta4(f, c, color);
		 }
		@Override
		public ReglasJuego creaReglas(int f, int c) {
			 return new ReglasJuegoConecta4();
		}

}
