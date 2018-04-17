package tp.pr4.logica;

import java.util.ArrayList;
import java.util.LinkedList;

import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.ColumnaLlena;
import tp.pr4.excepciones.DatosIncorrectos;
import tp.pr4.excepciones.FilaIncorrecta;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.jugadores.Jugador;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.reglas.ReglasJuego;
// TODO: Auto-generated Javadoc
/**
 * The Class Partida.
 * @param <T>
 */
public class Partida implements Observable<Observador>{

	/** The turno. */
	private FICHA turno;

	/** The tablero. */
	private Tablero tablero;
	private TableroSoloLectura tab;
	private ReglasJuego reglas;
	
	/** The terminada. */
	private boolean terminada;

	private ArrayList<Observador> obs = new ArrayList<Observador>();
  
	private LinkedList<Movimiento> undoStack = new LinkedList<Movimiento>();
	


	@Override
	public void addObserver(Observador o) {
		if(!obs.contains(o))
			obs.add(o);
		
	}

	@Override
	public void removeObserver(Observador o) {
		obs.remove(o);
		
	}
	/**
	 * Instantiates a new partida.
	 * @param juego 
	 */
	public Partida(ReglasJuego juego) {
		
		this.reglas = juego;
		this.turno = juego.jugadorInicial();
		this.tablero = juego.iniciaTablero();
		
		
	}

	/**
	 * Reset. Reinicia el juego.
	 */
	public void reset(ReglasJuego reglas) {

		this.reglas = reglas;
		this.turno = reglas.jugadorInicial();
		this.tablero = reglas.iniciaTablero();
		this.undoStack.clear();
		
		for(Observador o : obs) {
			o.onReset(tab, turno);
		}

	}

	/**
	 * Ejecuta movimiento.Pone la ficha con el metodo privado para buscar la
	 * posicion libre en la columna.
	 * 
	 * @param c
	 *            the c
	 * @return true, if successful
	 * @throws ColumnaIncorrecta 
	 * @throws ColumnaLlena 
	 * @throws FilaIncorrecta 
	 */
	public void ejecutaMovimiento(Movimiento mv)  {
				

		if(terminada)
			try {
				throw new MovimientoInvalido("Partida ya terminada");
			} catch (MovimientoInvalido e) {
				for(Observador o : obs) {
					o.onMovimientoIncorrecto(e);
				}
			}
		
		FICHA color = mv.getJugador();
		
		//Movimientostart() cuando el movimiento sea valido.
		//cuando salte error se vuelve a habilitar el flag una vez se resuelva.
		
		for(Observador o : obs) {
			o.onMovimientoStart(turno);
		}
		
		try {
			mv.ejecutaMovimiento(this.tablero);
		} catch (MovimientoInvalido e) {
			for(Observador o : obs) {
				o.onMovimientoIncorrecto(e);
			}
			throw e;
		} catch (ColumnaIncorrecta e) {
			for(Observador o : obs) {
				o.onError(e.toString());
			}
			throw e;
		} catch (ColumnaLlena e) {
			for(Observador o : obs) {
				o.onError(e.toString());
			}
			throw e;
		} catch (FilaIncorrecta e) {
			for(Observador o : obs) {
				o.onError(e.toString());
			}
			throw e;
		}
		
		
			undoStack.push(mv);
			
			if (!this.juegoAcabado(mv)) { 
				
				this.turno = this.reglas.siguienteTurno(this.getTurno());
				
				for(Observador o : obs) {
					o.onMovimientoEnd(tab, color, this.getTurno());
				}
			}
			
			else {
				this.terminada=true;
				for(Observador o : obs) {
					o.onPartidaTerminada(tab, turno);
				}
			}

	}
	
	public FICHA getTurno(){
		return this.turno;
	}
	public void setTurno(FICHA color){
		this.turno = color;
	}
	
	
	private boolean juegoAcabado(Movimiento mv){
		
		int f = mv.getFila();
		int c = mv.getColumna();
		FICHA ficha = this.reglas.hayGanador(f, c, this.turno, tablero);

		if (ficha != FICHA.VACIA || this.reglas.tablas(this.tablero)){
			this.turno = ficha;
			return true;
		}
		else return false;
	}
	

	/**
	 * Partida terminada.
	 * 
	 * @return true, if successful
	 */
	public boolean partidaTerminada() {

			return terminada;
	}

	/**
	 * Undo. Deshace el último movimiento, almacenando cada columna usada en cada turno en una pila, 
	 * para después buscar la primera casilla ocupada y ponerla a vacia.
	 * 
	 * @return true, if successful
	 */
	public void undo() {
		
		if (undoStack.isEmpty()) {
			
			for(Observador o : obs) {
				o.onUndoNotPossible();
			}
			return;
		} 
	
			Movimiento mov = undoStack.pop();
			mov.undo(this.tablero);

			this.turno = mov.getJugador();
			
			for(Observador o : obs) {
				o.onUndo(tab, turno, !undoStack.isEmpty());

			}

	}
	
	public Movimiento getMovimiento(FactoriaJuego factoria, Jugador jugador) {
		
		Movimiento mv = null;
			try {
				mv =  jugador.getMovimiento(factoria, this.tablero, this.turno);
			} catch (DatosIncorrectos e) {
				e.printStackTrace();
			}
			return mv;
			
			

	}
	
	public Movimiento getMovimientoAleatorio(FactoriaJuego factoria) {
		
		Movimiento mv = null;
		Jugador jugador = factoria.creaJugadorAleatorio();
		
		try {
			mv =  jugador.getMovimiento(factoria, this.tablero, this.turno);
		} catch (DatosIncorrectos e) {
			e.printStackTrace();
		}
		
		return mv;
		
	}
	public Movimiento getMovimientoGUI(FactoriaJuego factoria, int f, int c) {
		return factoria.creaMovimiento(f, c, turno);
	}
	

	/**
	 * 
	 * toString. Muestra el estado de la partida.
	 * 
	 */
	public String toString() {
		// hay que mostrar también el turno.
		String text = null;
		String sep = System.getProperty("line.separator");

		if (this.getTurno() == FICHA.BLANCA)
			text = "Juegan blancas";

		else if (this.getTurno() == FICHA.NEGRA)
			text = "Juegan negras";

		return this.tablero.toString() + sep + text;

	}
	

	/**
	 * To string ganador. Muestra el resultado final del juego.
	 * 
	 * @return the string
	 */
	public String toStringGanador() {
		String text = null;
		String sep = System.getProperty("line.separator");

		if (this.tablero.completo())
			text = "Empate";
		else if (this.getTurno() == FICHA.BLANCA)
			text = "Ganan las blancas";

		else if (this.getTurno() == FICHA.NEGRA)
			text = "Ganan las negras";

		return this.tablero.toString()+ sep + text;
	}

	
	public Tablero getTablero() {
		return this.tablero;
	}
	public void cambioJuego(ReglasJuego juego) {
		this.reset(juego);
		this.tab = new TableroSoloLectura(this);
	
		
		for(Observador o : obs) {
			o.onCambioJuego(tab, turno);
		}
	}

	public void notUndo() {
		for(Observador o : obs) {
			o.onUndoNotPossible();
		}
		
	}


}
