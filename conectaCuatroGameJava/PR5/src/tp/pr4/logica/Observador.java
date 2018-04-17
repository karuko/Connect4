package tp.pr4.logica;

import tp.pr4.excepciones.MovimientoInvalido;

public interface Observador {
	
	void onReset(TableroInmutable tab, FICHA turno);
	void onPartidaTerminada(TableroInmutable tablero, FICHA ganador);
	void onCambioJuego(TableroSoloLectura tab, FICHA turno);
	void onUndoNotPossible();
	void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas);
	void onMovimientoStart(FICHA turno);
	void onMovimientoEnd(TableroInmutable tablero,FICHA jugador, FICHA turno);
	void onMovimientoIncorrecto(MovimientoInvalido movimientoException);
	void onError(String s);
	
	
}
	
