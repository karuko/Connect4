package tp.pr4.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import tp.pr4.comandos.Comando;
import tp.pr4.comandos.CommandParser;
import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.ColumnaLlena;
import tp.pr4.excepciones.ErrorDeEjecucion;
import tp.pr4.excepciones.FilaIncorrecta;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.jugadores.Jugador;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Partida;
import tp.pr4.movimiento.Movimiento;
import tp.pr4.reglas.ReglasJuego;


// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 */
public class Controlador {

	/** The partida. */
	protected  Partida partida;
	/** The in. */
	protected Scanner in;
	protected FactoriaJuego factoria;
	
	/** The exit. */
	private boolean exit = false;
	private Jugador jugador1;
	private Jugador jugador2;
	private Boolean j = true;
	



	/**
	 * Instantiates a new controlador.
	 * 
	 * @param partida
	 *            the partida
	 * @param in
	 *            the in
	 * @param juego 
	 */
	public Controlador(Partida partida, Scanner in, FactoriaJuego juego) {
		
		this.partida = partida;
		this.in = in;
		this.factoria = juego;
		jugador1 = factoria.creaJugadorHumano(in); 
		jugador2 = factoria.creaJugadorHumano(in);

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
		
			jugador1 = factoria.creaJugadorHumano(in); 
			jugador2 = factoria.creaJugadorHumano(in);
			
		
	}
	public void reset(int f, int c){
		
		ReglasJuego reglas = factoria.creaReglas(f, c);
		this.partida.reset(reglas);
	
		jugador1 = factoria.creaJugadorHumano(in); 
		jugador2 = factoria.creaJugadorHumano(in);
	}
	
	public void undo() throws ErrorDeEjecucion{		
			this.partida.undo();
		
	}
	public void poner(){
		
		Movimiento mv;
		
			if(this.j){
					
					 mv = this.partida.getMovimiento(this.factoria, jugador1);
					this.partida.ejecutaMovimiento(mv);
					 this.j = false;
				}
				else{
					
					mv = this.partida.getMovimiento(this.factoria, jugador2);
					this.partida.ejecutaMovimiento(mv);
					this.j = true;
				}

			
	}
	
	public void poner(int col) {
		
	}
	public void exit(){
		this.exit = true;
		System.out.println("Saliendo del CONECTA4 Magico!!");
	}
	
	public void jugar(FactoriaJuego fact, int f, int c){
		
		this.factoria = fact;
		this.partida.reset(this.factoria.creaReglas(f, c));
		this.reset(f,c);
		
			
	}

	public void jugador(FICHA color, String tipoJugador) {
		
		
		
		if(tipoJugador.equalsIgnoreCase("HUMANO")){

			
			if(this.j == true)
				jugador1 = factoria.creaJugadorHumano(in);
			else
				jugador2 = factoria.creaJugadorHumano(in);
			
		}
		
		else if(tipoJugador.equalsIgnoreCase("ALEATORIO")){

			if(this.j == true)
				jugador1 = factoria.creaJugadorAleatorio();
			else
				jugador2 = factoria.creaJugadorAleatorio();
		
		
		this.partida.setTurno(color);
		}	
	}
	
public void run() throws IOException  {
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
		String line;
		Comando instrCommand;
		
		
	 while (!exit) {
		 	
		 		 System.out.println(partida.toString());
				 System.out.print("Qué quieres hacer?: ");
				 line = br.readLine();
				 instrCommand = CommandParser.parseCommand(line);
		            
		            if (instrCommand != null)
		            	try {
		            		instrCommand.execute(this);
		            	} catch (MovimientoInvalido | ColumnaIncorrecta | ColumnaLlena | FilaIncorrecta e) {
		     			   
		        			
		        		}
		            	
		                
		            else 
		            	System.err.println("Comando desconocido");
		            
		            
			}
			
	}

	
}




