package tp.pr4.factorias;

import java.util.Scanner;

import tp.pr4.jugadores.Jugador;
import tp.pr4.jugadores.JugadorAleatorioComplica;
import tp.pr4.jugadores.JugadorHumanoComplica;
import tp.pr4.logica.FICHA;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.movimiento.MovimientoComplica;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoComplica;

public class FactoriaJuegoComplica implements FactoriaJuego {

	@Override
	public Movimiento creaMovimiento(int fila, int col, FICHA color) {
		return new MovimientoComplica(fila,col, color);
	}

	@Override
	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioComplica();
	}

	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoComplica(sc);
	}

	@Override
	public ReglasJuego creaReglas(int f, int c) {
		return new ReglasJuegoComplica();
	}

}
