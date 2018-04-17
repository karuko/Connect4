package tp.pr4.control;


import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.ColumnaLlena;
import tp.pr4.excepciones.FilaIncorrecta;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.juego.ModoJuego;
import tp.pr4.jugadores.Jugador;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Partida;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.reglas.ReglasJuego;


// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 */
public  class ControladorGUI {

	/** The partida. */
	protected  Partida partida;
	/** The in. */

	protected FactoriaJuego factoria;
	protected ModoJuego jugador;
	
	

	/**
	 * Instantiates a new controlador.
	 * 
	 * @param partida
	 *            the partida
	 * @param in
	 *            the in
	 * @param juego 
	 */
	
	public ControladorGUI(Partida partida, FactoriaJuego juego) {
		
		this.partida = partida;
		this.factoria = juego;
	

	}

	/**
	 * Run.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ErrorDeEjecucion 
	 */
	
	public void reset(){
		
			ReglasJuego reglas = factoria.creaReglas(10, 10);
			this.partida.reset(reglas);

	}
	public void reset(int f, int c){
		
		ReglasJuego reglas = factoria.creaReglas(f, c);
		this.partida.reset(reglas);
		
	}
	
	public void undo() {		
		this.partida.undo();

		
	}
	public void poner(int f, int c){
		
		Movimiento mv = this.partida.getMovimientoGUI(factoria, f, c);
		try {
			this.partida.ejecutaMovimiento(mv);
		} catch (MovimientoInvalido | ColumnaIncorrecta | ColumnaLlena | FilaIncorrecta e) {
			   
			
		}
		
	}
	
	public void exit(){
		
		int n = JOptionPane.showOptionDialog(new JFrame(),"¿Seguro que quieres salir?", "Quit",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				null, null);
		if (n == 0){
			
			System.exit(0);
			}
		
	}
	
	public FICHA getTurno() {
		return this.partida.getTurno();
	}

	public void ponerAleatorio() {

				Movimiento mv = partida.getMovimientoAleatorio(factoria);
				try {
					partida.ejecutaMovimiento(mv);
				} catch (MovimientoInvalido | ColumnaIncorrecta | ColumnaLlena | FilaIncorrecta e) {
					   
					
				}
			
	}
	
	public void cambioJuego(FactoriaJuego juegoFac, ReglasJuego juego) {
		this.factoria = juegoFac;
		this.partida.cambioJuego(juego);
	
	}
	
	public void cambioJuego(FactoriaJuego juegoFac, ReglasJuego juego, String f, String c) {
		this.factoria = juegoFac;
		ReglasJuego reglas = factoria.creaReglas(new Integer(f), new Integer(c));
		this.partida.cambioJuego(reglas);
		
	}

	public void notUndo() {
		this.partida.notUndo();
		
	}

	
}




