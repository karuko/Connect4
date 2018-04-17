package tp.pr4.factorias;

import java.util.Scanner;

import tp.pr4.jugadores.Jugador;
import tp.pr4.jugadores.JugadorAleatorioReversi;
import tp.pr4.jugadores.JugadorHumanoReversi;
import tp.pr4.logica.FICHA;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.movimiento.MovimientoReversi;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoReversi;

public class FactoriaJuegoReversi implements FactoriaJuego {

	@Override
	public ReglasJuego creaReglas(int f, int c) {
		return new ReglasJuegoReversi();
	}

	@Override
	public Movimiento creaMovimiento(int fila, int col, FICHA color) {
		return new MovimientoReversi(fila, col, color);
	}

	@Override
	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioReversi();
	}

	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoReversi(sc);
	}

}
