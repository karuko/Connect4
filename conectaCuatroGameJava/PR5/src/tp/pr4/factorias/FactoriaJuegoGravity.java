package tp.pr4.factorias;

import java.util.Scanner;

import tp.pr4.jugadores.Jugador;
import tp.pr4.jugadores.JugadorAleatorioGravity;
import tp.pr4.jugadores.JugadorHumanoGravity;
import tp.pr4.logica.FICHA;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.movimiento.MovimientoGravity;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoGravity;

public class FactoriaJuegoGravity implements FactoriaJuego {


	@Override
	public Movimiento creaMovimiento(int fila, int col, FICHA color) {
		return new MovimientoGravity(fila,col, color);
	}

	@Override
	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioGravity();
	}

	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoGravity(sc);
	}

	@Override
	public ReglasJuego creaReglas(int f, int c) {
		return new ReglasJuegoGravity(f,c);
	}

	
}
