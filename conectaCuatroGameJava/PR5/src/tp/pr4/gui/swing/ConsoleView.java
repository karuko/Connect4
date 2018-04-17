package tp.pr4.gui.swing;

import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;

	
public class ConsoleView implements Observador{


	public ConsoleView(Observable<Observador> obs) {
		obs.addObserver(this);
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		System.out.println("Ganan las " + ganador);
		System.out.println("Saliendo del CONECTA4 Magico!!");
		
	}
	
	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUndoNotPossible() {
		System.err.println("No se puede deshacer");
		
	}
	
	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onMovimientoIncorrecto(MovimientoInvalido movimientoException) {
		System.err.println(movimientoException.toString());
		
	}

	@Override
	public void onReset(TableroInmutable tab, FICHA turno) {
		System.out.println("Partida reiniciada");
		
	}

	@Override
	public void onError(String s) {
		System.err.println(s);
		
	}



	@Override
	public void onMovimientoStart(FICHA turno) {
		// TODO Auto-generated method stub
		
	}
}

